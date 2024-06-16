package com.mall.domain.ao;

import cn.hutool.core.convert.Convert;
import com.mall.domain.entity.SupplierDO;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SupplierAddAO {

    private Long id;

    /**
     * 供货商名称
     */
    @NotBlank
    private String name;

    /**
     * 联系人姓名
     */
    @NotBlank
    private String contact;

    /**
     * 联系人电话
     */
    @NotBlank
    private String phone;

    /**
     * 联系人地址
     */
    @NotBlank
    private String address;

    public SupplierDO toDO() {
        return Convert.convert(SupplierDO.class, this);
    }

}
