package com.mall.service;

import com.mall.domain.ao.CategoryAddAO;
import com.mall.domain.vo.CategoryVO;

import java.util.List;

public interface CategoryService {

    CategoryVO getById(Long id);

    void add(CategoryAddAO ao);

    List<CategoryVO> getCategoryTree();
}
