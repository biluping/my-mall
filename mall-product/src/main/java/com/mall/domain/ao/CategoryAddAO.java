package com.mall.domain.ao;

import cn.hutool.core.convert.Convert;
import com.mall.domain.entity.CategoryDO;
import com.myboy.sql.annotation.Column;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CategoryAddAO {

    private Long id;

    @NotNull
    @Column(comment = "父分类id", defaultVal = "0")
    private Long pid;

    @NotBlank
    @Column(comment = "分类名")
    private String name;

    @NotBlank
    @Column(len = 200, comment = "分类图标url")
    private String iconUrl;

    @NotNull
    @Column(comment = "是否首页推荐")
    private Boolean isHomePageRecommend;

    @NotNull
    @Column(comment = "是否显示")
    private Boolean isShow;

    @NotNull
    @Column(comment = "排序")
    private Integer sort;

    public CategoryDO toDO() {
        return Convert.convert(CategoryDO.class, this);
    }
}
