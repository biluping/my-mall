package com.mall.domain.ao;

import cn.hutool.core.convert.Convert;
import com.mall.domain.entity.BrandDO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BrandAddAO {

    /**
     * 品牌名称
     */
    @NotBlank
    private String name;

    /**
     * 品牌图片url
     */
    private String imgUrl;

    /**
     * 品牌首字母
     */
    @NotBlank
    private String firstLetter;

    /**
     * 是否显示
     */
    @NotNull
    private Boolean isShow;

    /**
     * 排序
     */
    @NotNull
    private Integer sort;

    /**
     * 描述
     */
    private String remark;

    public BrandDO toDO() {
        return Convert.convert(BrandDO.class, this);
    }
}
