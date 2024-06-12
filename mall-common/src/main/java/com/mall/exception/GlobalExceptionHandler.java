package com.mall.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldError().getField() + " " + e.getBindingResult().getFieldError().getDefaultMessage();
    }

    @ExceptionHandler(value = BizException.class)
    public String handleBizException(BizException e) {
        return e.getMessage();
    }
}
