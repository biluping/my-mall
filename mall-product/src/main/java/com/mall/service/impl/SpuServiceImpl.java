package com.mall.service.impl;

import com.mall.mapper.SpuMapper;
import com.mall.service.SpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class SpuServiceImpl implements SpuService {

    private final SpuMapper spuMapper;

}