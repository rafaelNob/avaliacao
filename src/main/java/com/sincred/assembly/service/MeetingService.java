package com.sincred.assembly.service;

import com.sincred.assembly.model.Meeting;
import com.sincred.assembly.request.SaveMeetingRequest;
import com.sincred.assembly.response.FindAllMeetingByPageableResponse;
import com.sincred.assembly.response.FindByIdResponse;

public interface MeetingService {
    Meeting save(SaveMeetingRequest request);
    FindAllMeetingByPageableResponse listAllByPageable(Integer page, Integer size, String sort);
    Meeting findById(Long id);
    FindByIdResponse findByIdResponse(Long id);
}
