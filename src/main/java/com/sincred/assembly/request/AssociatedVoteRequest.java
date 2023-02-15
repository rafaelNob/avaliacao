package com.sincred.assembly.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssociatedVoteRequest {
    private String cpf;
    private Boolean vote;
    private Long meetingId;
}
