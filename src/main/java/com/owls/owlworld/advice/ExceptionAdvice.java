package com.owls.owlworld.advice;

import com.owls.owlworld.common.ErrorResponse;
import com.owls.owlworld.constant.ErrorCode;
import com.owls.owlworld.exception.BusinessErrorException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(BusinessErrorException.class)
    private ErrorResponse handleRuntimeErrorException(BusinessErrorException businessErrorException) {
        ErrorCode errorCode = businessErrorException.getErrorCode();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(errorCode.getCode());
        errorResponse.setMessage(errorCode.getMessage());
        errorResponse.setUserMessage(errorCode.getUserMessage());

        return errorResponse;
    }

    @ExceptionHandler(ResponseStatusException.class)
    private ErrorResponse handleResponseStatusException(ResponseStatusException responseStatusException) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(String.valueOf(responseStatusException.getStatus()));
        errorResponse.setMessage(responseStatusException.getReason());
        errorResponse.setUserMessage(responseStatusException.getMessage());

        return errorResponse;
    }
}
