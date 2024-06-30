package com.mall.domain.ao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.myboy.sql.annotation.Column;
import com.myboy.sql.constant.MySqlTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SkuAddAO {

    private String skuId;

    @Column(comment = "市场价")
    private BigDecimal marketPrice;

    @Column(comment = "价格")
    private BigDecimal price;

    @Column(comment = "成本价")
    private BigDecimal costPrice;

    @Column(comment = "库存")
    private Integer inventory;

    @Column(comment = "体积")
    private Integer volume;

    @Column(comment = "重量")
    private Integer weight;

    @Column(comment = "条码")
    private Integer barcodes;

    @Column(comment = "规格图片", len = 200)
    private String picUrl;

    @TableField(typeHandler = JacksonTypeHandler.class)
    @Column(comment = "其他规格", jdbcType = MySqlTypeEnum.TEXT)
    private List<String> otherSpecList;
}
