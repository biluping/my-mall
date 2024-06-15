package com.mall.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageAO {

    private Integer pageNum;

    private Integer pageSize;

    public <T> Page<T> toMPPage() {
        return new Page<>(pageNum, pageSize);
    }
}
