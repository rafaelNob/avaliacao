package com.sincred.assembly.service;

import com.sincred.assembly.model.AssociatedVote;
import com.sincred.assembly.request.AssociatedVoteRequest;
import com.sincred.assembly.response.AssociateVoteResponse;

public interface AssociatedVoteService {
    AssociatedVote save(AssociatedVoteRequest request);

    AssociateVoteResponse resultAgenda(Long id);
}
