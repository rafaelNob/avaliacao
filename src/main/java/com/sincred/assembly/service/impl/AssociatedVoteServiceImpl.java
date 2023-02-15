package com.sincred.assembly.service.impl;

import com.sincred.assembly.exceptions.ErrorOnProcessingRequestException;
import com.sincred.assembly.model.AssociatedVote;
import com.sincred.assembly.model.Meeting;
import com.sincred.assembly.repository.AssociatedVoteRepository;
import com.sincred.assembly.request.AssociatedVoteRequest;
import com.sincred.assembly.response.AssociateVoteResponse;
import com.sincred.assembly.response.common.StatusCodes;
import com.sincred.assembly.response.output.AssociateVoteOutput;
import com.sincred.assembly.service.AssociatedVoteService;
import com.sincred.assembly.utils.DocumentValidationUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.sincred.assembly.utils.DateUtil.compareDateAndHourSmallerEquals;

@Service
public class AssociatedVoteServiceImpl implements AssociatedVoteService {

    private final AssociatedVoteRepository associatedVoteRepository;
    private final MeetingServiceImpl meetingServiceImpl;
    private final DocumentValidationUtils documentValidationUtils;

    public AssociatedVoteServiceImpl(AssociatedVoteRepository associatedVoteRepository,
                                     MeetingServiceImpl meetingServiceImpl,
                                     DocumentValidationUtils documentValidationUtils) {
        this.associatedVoteRepository = associatedVoteRepository;
        this.meetingServiceImpl = meetingServiceImpl;
        this.documentValidationUtils = documentValidationUtils;
    }

    @Override
    public AssociatedVote save(AssociatedVoteRequest request) {
        Meeting meeting = validateOperation(request);
        AssociatedVote associatedVote = AssociatedVote.builder()
                .vote(request.getVote())
                .cpf(request.getCpf())
                .meeting(meeting)
                .build();
        return associatedVoteRepository.save(associatedVote);
    }

    @Override
    public AssociateVoteResponse resultAgenda(Long id) {
        Meeting meeting = meetingServiceImpl.findById(id);
        if (Objects.isNull(meeting))
            throw new ErrorOnProcessingRequestException(StatusCodes.Error.Util.DocumentInvalid);
        return AssociateVoteResponse.builder()
                .associateVoteOutput(AssociateVoteOutput.builder()
                        .meeting(meeting)
                        .build())
                .commonResponse(StatusCodes.Success.Meeting.NewMeetingSuccessfullyRegistered)
                .build();
    }

    private Meeting validateOperation(AssociatedVoteRequest request) {
        Boolean invalidCpf = documentValidationUtils.isInvalidCpf(request.getCpf());
        if (invalidCpf)
            throw new ErrorOnProcessingRequestException(StatusCodes.Error.Util.DocumentInvalid);
        String cpfFormatted = documentValidationUtils.cleanFormatting(request.getCpf());
        request.setCpf(cpfFormatted);
        if (associatedVoteRepository.existsByCpf(cpfFormatted))
            throw new ErrorOnProcessingRequestException(StatusCodes.Error.AssociatedVote.CpfAlreadyExists);
        Meeting meeting = meetingServiceImpl.findById(request.getMeetingId());
        if (Objects.isNull(meeting))
            throw new ErrorOnProcessingRequestException(StatusCodes.Error.Meeting.MeetingNotFound);
        if (compareDateAndHourSmallerEquals(meeting.getExpirationDate())) {
            throw new ErrorOnProcessingRequestException(StatusCodes.Error.Meeting.MeetingClosed);
        }
        return meeting;
    }
}
