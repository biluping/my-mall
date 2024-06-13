package com.mall.service.impl;

import cn.hutool.core.lang.Assert;
import com.mall.domain.ao.CategoryAddAO;
import com.mall.domain.entity.CategoryDO;
import com.mall.domain.vo.CategoryVO;
import com.mall.exception.BizException;
import com.mall.mapper.CategoryMapper;
import com.mall.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public CategoryVO getById(Long id) {
        List<CategoryDO> list = categoryMapper.selectList(null);
        CategoryDO categoryDO = categoryMapper.selectById(id);
        return Optional.ofNullable(categoryDO).map(it -> {
            CategoryVO vo = it.toVO();
            vo.setChildren(buildCategoryTree(list, it.getId()));
            return vo;
        }).orElse(null);
    }

    @Override
    public void add(CategoryAddAO ao) {
        Assert.isFalse(categoryMapper.nameExists(ao.getId(), ao.getName()), () -> new BizException("分类名已存在"));
        Assert.isTrue(ao.getPid() == 0 || categoryMapper.idExists(ao.getPid()), () -> new BizException("父分类不存在"));

        CategoryDO categoryDO = ao.toDO();
        if (ao.getId() == null) {
            categoryDO.insert();
        } else {
            categoryDO.updateById();
        }
    }

    @Override
    public List<CategoryVO> getCategoryTree() {
        List<CategoryDO> list = categoryMapper.selectList(null);
        return buildCategoryTree(list, 0L);
    }

    @Override
    public void deleteCategory(Long id) {
        Boolean childrenExists = categoryMapper.childrenExists(id);
        Assert.isFalse(childrenExists, () -> new BizException("请先删除子分类"));
        categoryMapper.deleteById(id);
    }

    private List<CategoryVO> buildCategoryTree(List<CategoryDO> list, Long pid) {
        return list.parallelStream().filter(it -> pid.equals(it.getPid()))
                .sorted(Comparator.comparing(CategoryDO::getSort))
                .map(it -> {
                    CategoryVO vo = it.toVO();
                    vo.setChildren(buildCategoryTree(list, it.getId()));
                    return vo;
                }).collect(Collectors.toList());
    }
}
