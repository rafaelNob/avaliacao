package com.sincred.assembly.response;

import com.sincred.assembly.response.common.AppResponse;
import com.sincred.assembly.response.common.CommonResponse;
import com.sincred.assembly.response.output.FindAllMeetingByPageableOutput;
import com.sincred.assembly.utils.PageInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class FindAllMeetingByPageableResponse extends AppResponse {
    private List<FindAllMeetingByPageableOutput> findAllByPageableOutput;
    private PageInfo pageInfo;

    public FindAllMeetingByPageableResponse(CommonResponse commonResponse) {
        super(commonResponse.getMessage(), commonResponse.getIsErro(), commonResponse.getStatusCode());
    }
    @Builder
    public FindAllMeetingByPageableResponse(CommonResponse commonResponse, List<FindAllMeetingByPageableOutput> findAllByPageableOutput, PageInfo pageInfo) {
        super(commonResponse.getMessage(), commonResponse.getIsErro(), commonResponse.getStatusCode());
        this.findAllByPageableOutput = findAllByPageableOutput;
        this.pageInfo = pageInfo;
    }
}
