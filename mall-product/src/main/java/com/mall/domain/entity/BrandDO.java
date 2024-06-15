package com.mall.domain.entity;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mall.domain.BaseDO;
import com.mall.domain.vo.BrandVO;
import com.myboy.sql.annotation.Column;
import com.myboy.sql.annotation.Table;
import com.myboy.sql.constant.MySqlTypeEnum;
import lombok.Data;

@Data
@Table(name = "mall_brand", comment = "商品品牌")
@TableName("mall_brand")
public class BrandDO extends BaseDO {

    @Column(comment = "品牌名称", len = 30)
    private String name;

    @Column(comment = "图片", len = 200)
    private String imgUrl;

    @Column(comment = "首字母", jdbcType = MySqlTypeEnum.CHAR, len = 1)
    private String firstLetter;

    @Column(comment = "是否展示")
    private Boolean isShow;

    @Column(comment = "排序")
    private Integer sort;

    @Column(comment = "备注", len = 200)
    private String remark;

    public BrandVO toVO() {
        return Convert.convert(BrandVO.class, this);
    }
}
