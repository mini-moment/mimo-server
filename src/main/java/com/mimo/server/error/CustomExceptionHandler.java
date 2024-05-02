package com.mimo.server.error;

import com.mimo.server.util.ApiUtil.ApiErrorResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiErrorResult<?>> handleException(CustomException e, HttpServletRequest request) {
        log.error("errorCode : {}, errorMessage : {}, url : {}", e.getCustomErrorCode(), e.getErrorMessage(), request.getRequestURL());
        ApiErrorResult<?> errorResult = new ApiErrorResult<>(e.getCustomErrorCode().getStatusCode(), e.getErrorMessage());
        return ResponseEntity.status(e.getCustomErrorCode().getHttpStatus()).body(errorResult);
    }
}
