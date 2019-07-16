package com.platform.papafood.exception;

public enum ErrorCode {
    /**
     * this class define errorCode and enum message for {@link BusinessException}
     * null mean there is no errorCode
     */
    USER_NOT_FOUND(-1);

    private Integer code;

    ErrorCode(Integer code) {
        this.code = code;
    }

    public Integer code() {
        return code;
    }

    public String format(String format, Object... args) {
        return this.name() + " " + String.format(format, args);
    }

    public String param(String param, Object value) {
        return format("(%s : %s)", param, value);
    }

    public String value(Object value) {
        return format("%s", value);
    }
}