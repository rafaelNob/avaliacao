package com.sincred.assembly.response.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse extends AppResponse {
    private Long code;
    private String description;
    private Boolean isError;

    public CommonResponse(Long code, String description,  Boolean isError) {
        super(description, isError, code);
        this.code = code;
        this.description = description;
        this.isError = isError;
    }
}
