package com.mall.domain.entity;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mall.domain.BaseDO;
import com.mall.domain.vo.SupplierVO;
import com.myboy.sql.annotation.Column;
import com.myboy.sql.annotation.Table;
import com.myboy.sql.constant.MySqlTypeEnum;
import lombok.Data;

@Data
@Table(name = "mall_supplier", comment = "供应商")
@TableName("mall_supplier")
public class SupplierDO extends BaseDO {

    @Column(len = 40, name = "供货商名称")
    private String name;

    @Column(comment = "联系人姓名", len = 20)
    private String contact;

    @Column(comment = "联系人电话", len = 11, jdbcType = MySqlTypeEnum.CHAR)
    private String phone;

    @Column(comment = "联系人地址")
    private String address;

    public SupplierVO toVO() {
        return Convert.convert(SupplierVO.class, this);
    }
}
