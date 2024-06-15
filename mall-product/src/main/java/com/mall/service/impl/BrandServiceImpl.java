package com.mall.service.impl;

import com.mall.mapper.BrandMapper;
import com.mall.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;

}