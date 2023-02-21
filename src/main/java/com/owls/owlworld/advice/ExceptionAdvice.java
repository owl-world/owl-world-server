package com.owls.owlworld.advice;

import com.owls.owlworld.common.ErrorResponse;
import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    private ErrorResponse handleRuntimeErrorException(BusinessErrorException businessErrorException) {
        ErrorCode errorCode = businessErrorException.getErrorCode();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(errorCode.getCode());
        errorResponse.setMessage(errorCode.getMessage());
        errorResponse.setUserMessage(errorCode.getUserMessage());

        return errorResponse;
    }
}
