package com.sincred.assembly.controller;

import com.sincred.assembly.exceptions.ErrorOnProcessingRequestException;
import com.sincred.assembly.model.AssociatedVote;
import com.sincred.assembly.request.AssociatedVoteRequest;
import com.sincred.assembly.response.AssociateVoteResponse;
import com.sincred.assembly.response.SaveAssociatedVoteResponse;
import com.sincred.assembly.response.common.AppResponse;
import com.sincred.assembly.response.common.StatusCodes;
import com.sincred.assembly.service.AssociatedVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/associated-vote")
public class AssociatedVoteController {

    @Autowired
    private AssociatedVoteService associatedVoteService;

    @PostMapping
    public ResponseEntity<AppResponse> saveAssociatedVote(@RequestBody AssociatedVoteRequest request) {
        try {
            AssociatedVote associatedVote = associatedVoteService.save(request);
            return new ResponseEntity<>(new SaveAssociatedVoteResponse(StatusCodes.Success.Meeting.NewMeetingSuccessfullyRegistered, associatedVote.getId()), HttpStatus.CREATED);
        } catch (ErrorOnProcessingRequestException e) {
            return new ResponseEntity<>(new SaveAssociatedVoteResponse(e.getCommonResponse()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/result-agenda/{id}")
    public ResponseEntity<AssociateVoteResponse> resultAgenda(@PathVariable Long id) {
        try {
            AssociateVoteResponse associateVoteResult = associatedVoteService.resultAgenda(id);
            return new ResponseEntity<>(new AssociateVoteResponse(StatusCodes.Success.Meeting.NewMeetingSuccessfullyRegistered, associateVoteResult.getAssociateVoteOutput()), HttpStatus.OK);
        } catch (ErrorOnProcessingRequestException e) {
            return new ResponseEntity<>(new AssociateVoteResponse(e.getCommonResponse()), HttpStatus.BAD_REQUEST);
        }
    }

}
