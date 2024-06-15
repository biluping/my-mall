package com.mall.service.impl;

import com.mall.mapper.${entity}Mapper;
import com.mall.service.${entity}Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ${entity}ServiceImpl implements ${entity}Service {

    private final ${entity}Mapper ${entitySmall}Mapper;

}