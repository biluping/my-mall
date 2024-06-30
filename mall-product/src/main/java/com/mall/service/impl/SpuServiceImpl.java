package com.mall.service.impl;

import com.mall.domain.ao.ProductAddAO;
import com.mall.domain.entity.SkuDO;
import com.mall.domain.entity.SpuDO;
import com.mall.esmapper.ProductDocMapper;
import com.mall.mapper.SpuMapper;
import com.mall.service.SkuService;
import com.mall.service.SpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SpuServiceImpl implements SpuService {

    private final SpuMapper spuMapper;
    private final SkuService skuService;
    private final ProductDocMapper productDocMapper;

    @Override
    public Long add(ProductAddAO ao) {
        SpuDO spuDO = ao.getSpuAddAO().toDO();
        spuMapper.insert(spuDO);

        List<SkuDO> skuDOList = ao.toSkuDOList(spuDO.getId());
        skuService.saveBatch(skuDOList);
        return spuDO.getId();
    }

}