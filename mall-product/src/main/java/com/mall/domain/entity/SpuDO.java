package com.mall.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.mall.domain.BaseDO;
import com.myboy.sql.annotation.Column;
import com.myboy.sql.annotation.Table;
import com.myboy.sql.constant.MySqlTypeEnum;
import lombok.Data;

import java.util.List;

@Data
@TableName("mall_spu")
@Table(name = "mall_spu", comment = "spu表")
public class SpuDO extends BaseDO {

    @Column(comment = "商品名称")
    private String name;

    @Column(comment = "商品编码", len = 30)
    private String code;

    @Column(comment = "一级分类id")
    private Long firstCategoryId;

    @Column(comment = "二级分类id")
    private Long secondCategoryId;

    @Column(comment = "三级分类id")
    private Long thirdCategoryId;

    @Column(comment = "商品卖点", len = 100)
    private String sellingPoint;

    @Column(comment = "商品主图")
    private String mainPicUrl;

    @TableField(typeHandler = JacksonTypeHandler.class)
    @Column(comment = "商品轮播图", len = 800, jdbcType = MySqlTypeEnum.VARCHAR)
    private List<String> carouselPicUrlList;

    @Column(comment = "商品视频")
    private String videoUrl;

    @Column(comment = "自定义分享海报")
    private String post;

    @Column(comment = "商品品牌id")
    private Long brandId;

    @Column(comment = "供货商id")
    private Long supplierId;

}
