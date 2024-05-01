package com.mimo.server.error;

public class CustomException extends RuntimeException {

    private final CustomErrorCode customErrorCode;
    private final String errorMessage;

    public CustomException(CustomErrorCode customErrorCode) {
        this.customErrorCode = customErrorCode;
        this.errorMessage = customErrorCode.getMessage();
    }

    public CustomErrorCode getCustomErrorCode() {
        return customErrorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
