package com.mall.service.impl;

import com.mall.mapper.SkuMapper;
import com.mall.service.SkuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SkuServiceImpl implements SkuService {

    private final SkuMapper skuMapper;

}