package com.capitole.common.handleExceptions.to;

public class InternalErrorException extends RuntimeException {

    private ErrorCode code;

    public InternalErrorException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
    public InternalErrorException(String errorMessage) {
        super(errorMessage);
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }
}
