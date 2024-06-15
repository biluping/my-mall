package com.mall.domain;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {

    private Long total;

    private List<T> data;

    public PageVO(Long total, List<T> data) {
        this.total = total;
        this.data = data;
    }


    public static <T> PageVO<T> wrap(IPage<T> page) {
        return new PageVO<>(page.getTotal(), page.getRecords());
    }
}
