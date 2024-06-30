package com.mall.domain.ao;

import cn.hutool.core.convert.Convert;
import com.mall.domain.entity.SpuDO;
import com.mall.domain.enums.ShippingMethod;
import lombok.Data;

import java.util.List;

@Data
public class SpuAddAO {

    private Long spuId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 一级分类id
     */
    private Long firstCategoryId;

    /**
     * 二级分类id
     */
    private Long secondCategoryId;

    /**
     * 三级分类id
     */
    private Long thirdCategoryId;

    /**
     * 商品卖点
     */
    private String sellingPoint;

    /**
     * 商品主图
     */
    private String mainPicUrl;

    /**
     * 商品名称
     */
    private List<String> carouselPicUrlList;

    /**
     * 商品视频
     */
    private String videoUrl;

    /**
     * 自定义分享海报
     */
    private String post;

    /**
     * 商品品牌id
     */
    private Long brandId;

    /**
     * 供货商id
     */
    private Long supplierId;

    /**
     * 规格类型，是否多规格
     */
    private Boolean isMultiSpec;

    /**
     * 多规格配置
     */
    private List<SpuDO.SpecParam> specList;

    /**
     * 商品详情
     */
    private String productDetail;

    /**
     * 虚拟销量
     */
    private Integer virtualSalesVolume;

    /**
     * 虚拟浏览量
     */
    private Integer virtualViews;

    /**
     * 库存预警
     */
    private Integer inventoryAlerts;

    /**
     * 是否线上库存
     */
    private Boolean isShowInventoryAlerts;

    /**
     * 配送方式
     */
    private ShippingMethod shippingMethod;

    public SpuDO toDO() {
        return Convert.convert(SpuDO.class, this);
    }
}
