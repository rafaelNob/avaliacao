package com.sincred.assembly.response;

import com.sincred.assembly.response.common.AppResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveMeetingResponse extends AppResponse {
    private Long meetingId;
    public SaveMeetingResponse(AppResponse appResponse) {
        super(appResponse.getMessage(), appResponse.getIsErro(), appResponse.getStatusCode());
    }

    public SaveMeetingResponse(AppResponse appResponse, Long meetingId) {
        super(appResponse.getMessage(), appResponse.getIsErro(), appResponse.getStatusCode());
        this.meetingId = meetingId;
    }
}
