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

    @Column(comment = "商品编码", len = 30, notNull = false)
    private String code;

    @Column(comment = "一级分类id")
    private Long firstCategoryId;

    @Column(comment = "二级分类id")
    private Long secondCategoryId;

    @Column(comment = "三级分类id")
    private Long thirdCategoryId;

    @Column(comment = "商品卖点", len = 100, defaultVal = "''")
    private String sellingPoint;

    @Column(comment = "商品主图")
    private String mainPicUrl;

    @TableField(typeHandler = JacksonTypeHandler.class)
    @Column(comment = "商品轮播图", jdbcType = MySqlTypeEnum.TEXT)
    private List<String> carouselPicUrlList;

    @Column(comment = "商品视频", len = 200, notNull = false)
    private String videoUrl;

    @Column(comment = "自定义分享海报", notNull = false, len = 200)
    private String post;

    @Column(comment = "商品品牌id", notNull = false)
    private Long brandId;

    @Column(comment = "供货商id", notNull = false)
    private Long supplierId;

    @Column(comment = "规格类型，是否多规格")
    private Boolean isMultiSpec;

    @TableField(typeHandler = JacksonTypeHandler.class)
    @Column(comment = "多规格配置", jdbcType = MySqlTypeEnum.TEXT)
    private List<SpecParam> specParamList;

    @Column(comment = "商品详情", jdbcType = MySqlTypeEnum.TEXT)
    private String productDetail;

    @Column(comment = "虚拟销量")
    private Integer virtualSalesVolume;

    @Column(comment = "虚拟浏览量")
    private Integer virtualViews;

    @Column(comment = "库存预警")
    private Integer inventoryAlerts;

    @Column(comment = "是否线上库存")
    private Boolean isShowInventoryAlerts;

    @Column(comment = "配送方式")
    private ShippingMethod shippingMethod;

    // 暂时快递运费包邮吧

    public enum ShippingMethod {
        EXPRESS_DELIVERY, IN_STORE_PICKUP
    }

    @Data
    public static class SpecParam {

        private String name;

        private Boolean hasImg;

        private List<SpecItem> itemList;

        @Data
        public static class SpecItem {
            private String imgUrl;
            private String itemName;
        }

    }

}
