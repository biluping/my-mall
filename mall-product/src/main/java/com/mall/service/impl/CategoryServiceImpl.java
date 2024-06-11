package com.mall.service.impl;

import com.mall.entity.CategoryDO;
import com.mall.mapper.CategoryMapper;
import com.mall.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDO getById(Long id) {
        return categoryMapper.selectById(id);
    }
}
