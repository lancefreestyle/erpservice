package com.capgemini.cn.core.exception;

public class CpmBusinessException extends RuntimeException {

    private static final long serialVersionUID = 3570458085891996707L;

    protected ExceptionTypeEnum exceptionType = ExceptionTypeEnum.NORMAL;

    public CpmBusinessException(Throwable e) {
        super(e.getMessage(), e);
    }

    public CpmBusinessException(String message) {
        super(message);
    }

    public CpmBusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CpmBusinessException(Throwable e, ExceptionTypeEnum exceptionType) {
        super(e.getMessage(), e);
        this.exceptionType = exceptionType;
    }

    public CpmBusinessException(String message, ExceptionTypeEnum exceptionType) {
        super(message);
        this.exceptionType = exceptionType;
    }

    public CpmBusinessException(String message, Throwable throwable, ExceptionTypeEnum exceptionType) {
        super(message, throwable);
        this.exceptionType = exceptionType;
    }

    public ExceptionTypeEnum getExceptionType() {
        return exceptionType;
    }
}
