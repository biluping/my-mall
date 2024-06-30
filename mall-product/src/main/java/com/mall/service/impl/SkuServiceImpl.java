package com.mall.service.impl;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.mall.domain.entity.SkuDO;
import com.mall.mapper.SkuMapper;
import com.mall.service.SkuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class SkuServiceImpl implements SkuService {

    private final SkuMapper skuMapper;

    @Override
    public void saveBatch(List<SkuDO> skuDOList) {
        Db.saveBatch(skuDOList);
    }
}