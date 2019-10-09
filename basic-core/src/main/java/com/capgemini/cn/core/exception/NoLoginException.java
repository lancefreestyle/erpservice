package com.capgemini.cn.core.exception;

public class NoLoginException extends CpmBusinessException {

    public NoLoginException(Throwable e) {
        super(e);
    }

    public NoLoginException(String message) {
        super(message);
    }

    public NoLoginException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NoLoginException(Throwable e, ExceptionTypeEnum exceptionType) {
        super(e, exceptionType);
    }

    public NoLoginException(String message, ExceptionTypeEnum exceptionType) {
        super(message, exceptionType);
    }

    public NoLoginException(String message, Throwable throwable, ExceptionTypeEnum exceptionType) {
        super(message, throwable, exceptionType);
    }
}
