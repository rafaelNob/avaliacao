package com.sincred.assembly.response;

import com.sincred.assembly.response.common.AppResponse;
import com.sincred.assembly.response.common.CommonResponse;
import com.sincred.assembly.response.output.AssociateVoteOutput;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssociateVoteResponse extends AppResponse {
    private AssociateVoteOutput associateVoteOutput;

    public AssociateVoteResponse(CommonResponse commonResponse) {
        super(commonResponse.getMessage(), commonResponse.getIsErro(), commonResponse.getStatusCode());
    }

    @Builder
    public AssociateVoteResponse(CommonResponse commonResponse, AssociateVoteOutput associateVoteOutput) {
        super(commonResponse.getMessage(), commonResponse.getIsErro(), commonResponse.getStatusCode());
        this.associateVoteOutput = associateVoteOutput;
    }
}
