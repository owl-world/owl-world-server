package com.owls.owlworld.exception;

import com.owls.owlworld.constant.ErrorCode;

public class BusinessErrorException extends RuntimeException {

    private ErrorCode errorCode;

    public BusinessErrorException(ErrorCode errorCode) {
        super(errorCode.getCode() + " : " + errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
