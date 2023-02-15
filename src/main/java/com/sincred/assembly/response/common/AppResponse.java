package com.sincred.assembly.response.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AppResponse {
    private String message;
    private Boolean isErro;
    private long statusCode;

    public AppResponse(String message, Boolean isErro, long statusCode) {
        this.message = message;
        this.isErro = isErro;
        this.statusCode = statusCode;
    }

}
