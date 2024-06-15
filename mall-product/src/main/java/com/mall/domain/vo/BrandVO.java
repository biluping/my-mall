package com.mall.domain.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.myboy.sql.annotation.Table;
import lombok.Data;

@Data
@Table(name = "mall_brand", comment = "商品品牌")
@TableName("mall_brand")
public class BrandVO {

    private Long id;

    private String name;

    private String imgUrl;

    private String firstLetter;

    private Boolean isShow;

    private Integer sort;

    private String remark;
}
