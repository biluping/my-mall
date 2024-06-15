package com.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.domain.PageVO;
import com.mall.domain.ao.BrandAddAO;
import com.mall.domain.ao.BrandPageAO;
import com.mall.domain.entity.BrandDO;
import com.mall.domain.vo.BrandVO;
import com.mall.mapper.BrandMapper;
import com.mall.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;

    @Override
    public Long add(BrandAddAO ao) {
        BrandDO brandDO = ao.toDO();
        if (brandDO.getId() == null) {
            brandDO.insert();
        } else {
            brandDO.updateById();
        }
        return brandDO.getId();
    }

    @Override
    public BrandVO getById(Long id) {
        BrandDO brandDO = brandMapper.selectById(id);
        return brandDO.toVO();
    }

    @Override
    public void delete(Long id) {
        brandMapper.deleteById(id);
    }

    @Override
    public PageVO<BrandVO> page(BrandPageAO pageAO) {
        LambdaQueryWrapper<BrandDO> wr = Wrappers.lambdaQuery(BrandDO.class)
                .like(StrUtil.isNotBlank(pageAO.getBrandName()), BrandDO::getName, pageAO.getBrandName())
                .orderByAsc(BrandDO::getSort);
        Page<BrandDO> page = brandMapper.selectPage(pageAO.toMPPage(), wr);
        return PageVO.wrap(page.convert(BrandDO::toVO));
    }
}