package com.capitole.common.handleExceptions.to;

public class InternalErrorException extends RuntimeException {
    public InternalErrorException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public InternalErrorException(String errorMessage) {
        super(errorMessage);
    }
}
