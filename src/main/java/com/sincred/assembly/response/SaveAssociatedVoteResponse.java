package com.sincred.assembly.response;

import com.sincred.assembly.response.common.AppResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveAssociatedVoteResponse extends AppResponse {
    private Long associatedVoteId;
    public SaveAssociatedVoteResponse(AppResponse appResponse) {
        super(appResponse.getMessage(), appResponse.getIsErro(), appResponse.getStatusCode());
    }

    public SaveAssociatedVoteResponse(AppResponse appResponse, Long associatedVoteId) {
        super(appResponse.getMessage(), appResponse.getIsErro(), appResponse.getStatusCode());
        this.associatedVoteId = associatedVoteId;
    }
}
