package com.mimo.server.error;

import org.springframework.http.HttpStatus;

public enum CustomErrorCode {
    INVALID_DATA_FORMAT(ErrorMessage.INVALID_DATA_FORMAT, HttpStatus.BAD_REQUEST, 400),
	VIDEO_UPLOAD_SERVER_ERROR(ErrorMessage.VIDEO_UPLOAD_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, 512),
    IMAGE_UPLOAD_SERVER_ERROR(ErrorMessage.IMAGE_UPLOAD_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR,513);

    private final String message;
    private final HttpStatus httpStatus;

    private final int statusCode;

    CustomErrorCode(String message, HttpStatus httpStatus, int statusCode) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getStatusCode() {
        return statusCode;
    }
}