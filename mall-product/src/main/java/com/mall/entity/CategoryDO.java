package com.mall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mall.db.BaseDO;
import com.myboy.sql.annotation.Column;
import com.myboy.sql.annotation.Table;
import lombok.Data;

@Data
@TableName("mall_category")
@Table(name = "mall_category", comment = "商品分类表")
public class CategoryDO extends BaseDO {

    @Column(comment = "父分类id", defaultVal = "0")
    private Long pid;

    @Column(comment = "分类名")
    private String name;

    @Column(len = 200, comment = "分类图标url")
    private String iconUrl;

    @Column(comment = "是否首页推荐")
    private Boolean isHomePageRecommend;

    @Column(comment = "是否显示")
    private Boolean isShow;

    @Column(comment = "排序")
    private Integer orderNo;

}
