package com.sincred.assembly.service;

import com.sincred.assembly.model.AssociatedVote;
import com.sincred.assembly.model.Meeting;
import com.sincred.assembly.repository.AssociatedVoteRepository;
import com.sincred.assembly.repository.MeetingRepository;
import com.sincred.assembly.request.AssociatedVoteRequest;
import com.sincred.assembly.service.impl.AssociatedVoteServiceImpl;
import com.sincred.assembly.service.impl.MeetingServiceImpl;
import com.sincred.assembly.utils.DocumentValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssociatedVoteServiceTest {
    @Mock
    private MeetingRepository meetingRepository;

    private AssociatedVoteServiceImpl associatedVoteServiceImpl;
    @Mock
    private AssociatedVoteRepository associatedVoteRepository;
    @Mock
    private MeetingServiceImpl meetingService = new MeetingServiceImpl();
    @Mock
    private DocumentValidationUtils documentValidationUtils = new DocumentValidationUtils();

    @BeforeEach
    void setUp() {
        this.associatedVoteServiceImpl
                = new AssociatedVoteServiceImpl(associatedVoteRepository, meetingService, documentValidationUtils);
    }

    @Test
    public void testSaveSuccess() {
        Meeting meeting = new Meeting();
        meeting.setDescription("teste 001");
        AssociatedVoteRequest request = AssociatedVoteRequest.builder()
                .cpf("248.451.580-43")
                .vote(Boolean.TRUE)
                .meetingId(null)
                .build();
        when(associatedVoteRepository.save(new AssociatedVote()))
                .thenReturn(any(AssociatedVote.class));

        when(meetingRepository.findById(1L))
                .thenReturn(Optional.of(meeting));

      //  AssociatedVote saveReturn = associatedVoteServiceImpl.save(request);
    }
}
