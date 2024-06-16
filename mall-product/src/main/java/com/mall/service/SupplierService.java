package com.mall.service;

import com.mall.domain.PageVO;
import com.mall.domain.ao.SupplierAddAO;
import com.mall.domain.ao.SupplierPageAO;
import com.mall.domain.vo.SupplierVO;

public interface SupplierService {

    Long add(SupplierAddAO ao);

    SupplierVO getById(Long id);

    Long delete(Long id);

    PageVO<SupplierVO> page(SupplierPageAO pageAO);
}