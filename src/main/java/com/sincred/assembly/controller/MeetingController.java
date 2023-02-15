package com.sincred.assembly.controller;

import com.sincred.assembly.exceptions.ErrorOnProcessingRequestException;
import com.sincred.assembly.model.Meeting;
import com.sincred.assembly.request.SaveMeetingRequest;
import com.sincred.assembly.response.FindAllMeetingByPageableResponse;
import com.sincred.assembly.response.FindByIdResponse;
import com.sincred.assembly.response.SaveMeetingResponse;
import com.sincred.assembly.response.common.StatusCodes;
import com.sincred.assembly.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @PostMapping
    public ResponseEntity<SaveMeetingResponse> saveMeeting(@RequestBody SaveMeetingRequest request) {
        try {
            Meeting meeting = meetingService.save(request);
            return new ResponseEntity<>(new SaveMeetingResponse(StatusCodes.Success.Meeting.NewMeetingSuccessfullyRegistered, meeting.getId()), HttpStatus.CREATED);
        } catch (ErrorOnProcessingRequestException e) {
            return new ResponseEntity<>(new SaveMeetingResponse(e.getCommonResponse()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<FindAllMeetingByPageableResponse> listAllByPageable(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                                              @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                                              @RequestParam(value = "description", defaultValue = "description") String sort) {
        return new ResponseEntity<>(meetingService.listAllByPageable(page, size, sort), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindByIdResponse> findById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(meetingService.findByIdResponse(id), HttpStatus.OK);
        } catch (ErrorOnProcessingRequestException e) {
            return new ResponseEntity<>(new FindByIdResponse(e.getCommonResponse()), HttpStatus.BAD_REQUEST);
        }

    }
}
