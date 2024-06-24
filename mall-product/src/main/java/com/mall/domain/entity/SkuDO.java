package com.mall.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.mall.domain.BaseDO;
import com.myboy.sql.annotation.Column;
import com.myboy.sql.annotation.Table;
import com.myboy.sql.constant.MySqlTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Table(name = "mall_sku", comment = "sku表")
@TableName("mall_sku")
public class SkuDO extends BaseDO {

    @Column(comment = "skuId")
    private Long spuId;

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
    private Map<String, String> otherSpec;

}
