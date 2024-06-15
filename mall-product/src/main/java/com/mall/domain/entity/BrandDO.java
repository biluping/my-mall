package com.mall.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mall.domain.BaseDO;
import com.myboy.sql.annotation.Table;
import lombok.Data;

@Data
@Table(name = "mall_brand", comment = "商品品牌")
@TableName("mall_brand")
public class BrandDO extends BaseDO {

    private String name;

    private String imgUrl;

    private String firstLetter;

    private Boolean isShow;

    private Integer sort;
}
