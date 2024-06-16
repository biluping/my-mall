package com.mall.domain.vo;

import lombok.Data;

@Data
public class SupplierVO {

    private Long id;

    /**
     * 供货商名称
     */
    private String name;

    /**
     * 联系人姓名
     */
    private String contact;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 联系人地址
     */
    private String address;

}
