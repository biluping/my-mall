package com.mall.service;

import com.mall.domain.entity.SkuDO;

import java.util.List;

public interface SkuService {

    void saveBatch(List<SkuDO> skuDOList);
}