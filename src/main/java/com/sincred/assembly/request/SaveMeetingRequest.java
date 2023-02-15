package com.sincred.assembly.request;

import lombok.Data;

@Data
public class SaveMeetingRequest {
    private String description;
    private String expirationDate;
}
