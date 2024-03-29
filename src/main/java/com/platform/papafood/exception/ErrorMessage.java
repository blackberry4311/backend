package com.platform.papafood.exception;

import java.util.Objects;

/**
 * homertruong
 */

public class ErrorMessage {

    public static final String APP_ERROR_MESSAGE = "Application error, please contact Administrator for support!";
    public static final String APP_INVALID_PARAM = "Params are invalid. Please re-check them.";
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ErrorMessage that = (ErrorMessage) o;

        if (code != that.code) {
            return false;
        }
        return Objects.equals(message, that.message);

    }

    @Override
    public String toString() {
        return "ErrorMessage{" + "code=" + code + ", message='" + message + '\'' + '}';
    }
}
