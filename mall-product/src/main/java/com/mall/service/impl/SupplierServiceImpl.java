package com.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.domain.PageVO;
import com.mall.domain.ao.SupplierAddAO;
import com.mall.domain.ao.SupplierPageAO;
import com.mall.domain.entity.SupplierDO;
import com.mall.domain.vo.SupplierVO;
import com.mall.mapper.SupplierMapper;
import com.mall.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierMapper supplierMapper;

    @Override
    public Long add(SupplierAddAO ao) {
        SupplierDO supplierDO = ao.toDO();
        if (supplierDO.getId() != null) {
            supplierDO.updateById();
        } else {
            supplierDO.insert();
        }
        return supplierDO.getId();
    }

    @Override
    public SupplierVO getById(Long id) {
        SupplierDO supplierDO = supplierMapper.selectById(id);
        return supplierDO.toVO();
    }

    @Override
    public Long delete(Long id) {
        supplierMapper.deleteById(id);
        return id;
    }

    @Override
    public PageVO<SupplierVO> page(SupplierPageAO pageAO) {
        LambdaQueryWrapper<SupplierDO> wr = Wrappers.lambdaQuery(SupplierDO.class)
                .eq(StrUtil.isNotBlank(pageAO.getName()), SupplierDO::getName, pageAO.getName());
        Page<SupplierDO> page = supplierMapper.selectPage(pageAO.toMPPage(), wr);
        return PageVO.wrap(page.convert(SupplierDO::toVO));
    }
}