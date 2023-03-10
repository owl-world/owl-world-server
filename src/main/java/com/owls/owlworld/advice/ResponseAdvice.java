package com.owls.owlworld.advice;

import com.owls.owlworld.common.BaseResponseBody;
import com.owls.owlworld.common.ErrorResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice("com.owls.owlworld")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
        ServerHttpResponse response) {
        if (body instanceof ErrorResponse) {
            ErrorResponse errorResponse = (ErrorResponse) body;

            BaseResponseBody<ErrorResponse> baseResponseBody = new BaseResponseBody<>();
            baseResponseBody.setResult(false);
            baseResponseBody.setErrorResponse(errorResponse);

            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            return baseResponseBody;
        }

        BaseResponseBody<Object> baseResponseBody = new BaseResponseBody<>();
        baseResponseBody.setData(body);
        baseResponseBody.setResult(true);

        return baseResponseBody;
    }
}
