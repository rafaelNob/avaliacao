package com.sincred.assembly.service.impl;

import com.sincred.assembly.exceptions.ErrorOnProcessingRequestException;
import com.sincred.assembly.model.Meeting;
import com.sincred.assembly.repository.MeetingRepository;
import com.sincred.assembly.request.SaveMeetingRequest;
import com.sincred.assembly.response.FindAllMeetingByPageableResponse;
import com.sincred.assembly.response.FindByIdResponse;
import com.sincred.assembly.response.common.StatusCodes;
import com.sincred.assembly.response.output.FindAllMeetingByPageableOutput;
import com.sincred.assembly.response.output.FindByIdMeetingOutput;
import com.sincred.assembly.service.MeetingService;
import com.sincred.assembly.utils.DateUtil;
import com.sincred.assembly.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.sincred.assembly.utils.DateUtil.compareDateAndHourBigger;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    /*public MeetingServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }*/

    @Override
    public Meeting save(SaveMeetingRequest request) {
        Meeting meeting =
                Meeting.builder()
                        .description(request.getDescription())
                        .expirationDate(getExpirationDate(request.getExpirationDate()))
                        .build();
        return meetingRepository.save(meeting);
    }

    @Override
    public FindAllMeetingByPageableResponse listAllByPageable(Integer page, Integer size, String sort) {
        Page<Meeting> meetingPage = meetingRepository.findAll(PageRequest.of(page, size, Sort.by(sort)));
        List<FindAllMeetingByPageableOutput> findAllByPageableOutputList = meetingPage
                .stream()
                .map(FindAllMeetingByPageableOutput::new)
                .collect(Collectors.toList());
        return FindAllMeetingByPageableResponse.builder()
                .findAllByPageableOutput(findAllByPageableOutputList)
                .pageInfo(PageInfo.builder()
                        .page(meetingPage)
                        .build())
                .commonResponse(StatusCodes.Success.Meeting.NewMeetingSuccessfullyRegistered)
                .build();
    }

    @Override
    public Meeting findById(Long id) {
        return meetingRepository.findById(id).orElse(null);
    }

    @Override
    public FindByIdResponse findByIdResponse(Long id) {
        Meeting meeting = findById(id);
        if (Objects.isNull(meeting))
            throw new ErrorOnProcessingRequestException(StatusCodes.Error.Meeting.MeetingNotFound);

        return FindByIdResponse.builder()
                .commonResponse(StatusCodes.Success.Meeting.NewMeetingSuccessfullyRegistered)
                .findByIdMeetingOutput(FindByIdMeetingOutput.builder()
                        .meeting(meeting)
                        .build())
                .build();
    }

    private LocalDateTime getExpirationDate(String expirationDate) {
        var MINUTE = 1l;
        LocalDateTime expirationDateTemp;
        LocalDateTime expirationDateReq = DateUtil.stringForLocalDateTime(expirationDate);
        if (!compareDateAndHourBigger(expirationDateReq)) {
            expirationDateTemp = expirationDateReq.plusMinutes(MINUTE);
        } else {
            expirationDateTemp = expirationDateReq;
        }
        return expirationDateTemp;
    }
}
