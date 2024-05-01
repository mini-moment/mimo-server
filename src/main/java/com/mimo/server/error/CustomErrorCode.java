package com.mimo.server.error;

public enum CustomErrorCode {
    INVALID_DATA_FORMAT("Invalid data format");
    private final String message;

    CustomErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}