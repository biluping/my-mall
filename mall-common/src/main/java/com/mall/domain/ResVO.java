package com.mall.domain;

import lombok.Data;

@Data
public class ResVO<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> ResVO<T> ok(T data) {
        ResVO<T> vo = new ResVO<>();
        vo.setCode(0);
        vo.setData(data);
        vo.setMsg("ok");
        return vo;
    }

    public static <T> ResVO<T> bad(T msg) {
        ResVO<T> vo = new ResVO<>();
        vo.setCode(400);
        vo.setData(msg);
        vo.setMsg("bad");
        return vo;
    }
}
