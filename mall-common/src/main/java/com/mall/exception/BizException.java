package com.mall.exception;

public class BizException extends RuntimeException {

    private String msg;

    public BizException(String msg) {
        super(msg);
    }
}
