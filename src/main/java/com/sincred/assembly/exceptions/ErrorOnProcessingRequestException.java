package com.sincred.assembly.exceptions;


import com.sincred.assembly.response.common.CommonResponse;

public class ErrorOnProcessingRequestException extends RuntimeException {
    private final CommonResponse commonResponse;

    public ErrorOnProcessingRequestException(CommonResponse commonResponse) {
        this.commonResponse = commonResponse;
    }

    public CommonResponse getCommonResponse() {
        return commonResponse;
    }

    public static void throww(CommonResponse commonResponse) {
        throw new ErrorOnProcessingRequestException(commonResponse);
    }
}
