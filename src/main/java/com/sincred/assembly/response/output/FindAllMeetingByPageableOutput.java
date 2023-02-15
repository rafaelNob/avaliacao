package com.sincred.assembly.response.output;

import com.sincred.assembly.model.Meeting;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FindAllMeetingByPageableOutput {
    private Long id;
    private String description;
    private LocalDateTime expirationDate;
    private LocalDateTime createdDate;

    public FindAllMeetingByPageableOutput(Meeting meeting) {
        this.id = meeting.getId();
        this.description = meeting.getDescription();
        this.expirationDate = meeting.getExpirationDate();
        this.createdDate = meeting.getCreatedDate();
    }
}
