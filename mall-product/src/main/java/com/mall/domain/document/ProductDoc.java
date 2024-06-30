package com.mall.domain.document;

import lombok.Data;
import org.dromara.easyes.annotation.IndexName;

@Data
@IndexName
public class ProductDoc {

    private String id;

    private Long spuId;

    private String name;
}
