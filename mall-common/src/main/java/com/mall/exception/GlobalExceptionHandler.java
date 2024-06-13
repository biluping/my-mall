package com.mall.exception;

import com.mall.domain.ResVO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings("all")
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResVO<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResVO.bad(e.getBindingResult().getFieldError().getField() + " " + e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = BizException.class)
    public ResVO<String> handleBizException(BizException e) {
        return ResVO.bad(e.getMessage());
    }
}
