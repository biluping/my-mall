package com.mall.domain.entity;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mall.domain.BaseDO;
import com.mall.domain.vo.CategoryVO;
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
    private Integer sort;

    public CategoryVO toVO() {
        return Convert.convert(CategoryVO.class, this);
    }

}
