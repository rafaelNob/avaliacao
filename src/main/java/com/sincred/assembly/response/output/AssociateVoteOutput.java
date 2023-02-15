package com.sincred.assembly.response.output;

import com.sincred.assembly.model.AssociatedVote;
import com.sincred.assembly.model.Meeting;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AssociateVoteOutput {
    private int resultForYes;
    private int resultForNo;

    @Builder
    public AssociateVoteOutput(Meeting meeting) {
        List<AssociatedVote> associatedVoteList = meeting.getAssociatedVotes().stream().filter(m -> m.getVote().equals(Boolean.TRUE)).collect(Collectors.toList());
        this.resultForYes = associatedVoteList.size();
        this.resultForNo = meeting.getAssociatedVotes().size() - associatedVoteList.size();
    }
}
