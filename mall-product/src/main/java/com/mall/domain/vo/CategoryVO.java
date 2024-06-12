package com.mall.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CategoryVO {

    private Long id;

    /**
     * 父分类id
     */
    private Long pid;

    /**
     * 分类名
     */
    private String name;

    /**
     * 分类图标url
     */
    private String iconUrl;

    /**
     * 是否首页推荐
     */
    private Boolean isHomePageRecommend;

    /**
     * 是否显示
     */
    private Boolean isShow;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 子分类
     */
    private List<CategoryVO> children;
}
