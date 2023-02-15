package com.sincred.assembly.response.output;

import com.sincred.assembly.model.AssociatedVote;
import com.sincred.assembly.model.Meeting;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FindByIdMeetingOutput extends FindAllMeetingByPageableOutput {
    private List<AssociatedVote> associatedVotes;

    @Builder
    public FindByIdMeetingOutput(Meeting meeting) {
        super(meeting);
        this.associatedVotes = meeting.getAssociatedVotes();
    }
}
