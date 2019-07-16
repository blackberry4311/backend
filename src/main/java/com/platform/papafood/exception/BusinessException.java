package com.platform.papafood.exception;

public class BusinessException extends Exception {

    private static final long serialVersionUID = 8713639038875182018L;
    private final Integer code;

    public BusinessException(ErrorCode errorCode, Object args) {
        super(errorCode.value(args));
        this.code = errorCode.code();
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.name());
        this.code = errorCode.code();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.code = null;
    }

    public BusinessException(String message) {
        super(message);
        this.code = null;
    }

    public Integer getCode() {
        return code;
    }

}
