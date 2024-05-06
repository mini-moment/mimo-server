package com.mimo.server.util;

import com.mimo.server.error.CustomErrorCode;

public class ApiUtil {

    /**
     * REST API 호출 성공시 반환 메서드
     *
     * @param response response body
     * @return @{@link ApiSuccessResult}
     */
    public static <T> ApiSuccessResult<T> success(T response) {
        return new ApiSuccessResult<>(response);
    }

    /**
     * REST API 호출 실패시 반환 메서드
     *
     * @param code    server failure code
     * @param message response message
     * @return @{@link ApiErrorResult}
     */
    public static <T> ApiErrorResult<T> error(int code, String message) {
        return new ApiErrorResult<>(code, message);
    }

    public static class ApiSuccessResult<T> {
        private final T data;

        private ApiSuccessResult(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    public static class ApiErrorResult<T> {
        private final int statusCode;
        private final String message;

        public ApiErrorResult(int customErrorCode, String message) {
            this.statusCode = customErrorCode;
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public String getMessage() {
            return message;
        }

    }
}
