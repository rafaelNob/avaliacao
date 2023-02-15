package com.sincred.assembly.response;

import com.sincred.assembly.response.common.AppResponse;
import com.sincred.assembly.response.common.CommonResponse;
import com.sincred.assembly.response.output.FindByIdMeetingOutput;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FindByIdResponse extends AppResponse {
    private FindByIdMeetingOutput findByIdMeetingOutput;

    public FindByIdResponse(CommonResponse commonResponse) {
        super(commonResponse.getMessage(), commonResponse.getIsErro(), commonResponse.getStatusCode());
    }

    @Builder
    public FindByIdResponse(CommonResponse commonResponse, FindByIdMeetingOutput findByIdMeetingOutput) {
        super(commonResponse.getMessage(), commonResponse.getIsErro(), commonResponse.getStatusCode());
        this.findByIdMeetingOutput = findByIdMeetingOutput;
    }
}
