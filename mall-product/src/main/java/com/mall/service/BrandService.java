package com.mall.service;

import com.mall.domain.PageVO;
import com.mall.domain.ao.BrandAddAO;
import com.mall.domain.ao.BrandPageAO;
import com.mall.domain.vo.BrandVO;

public interface BrandService {

    Long add(BrandAddAO ao);

    BrandVO getById(Long id);

    void delete(Long id);

    PageVO<BrandVO> page(BrandPageAO pageAO);
}