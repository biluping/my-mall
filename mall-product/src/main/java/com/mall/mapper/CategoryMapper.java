package com.mall.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mall.domain.entity.CategoryDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends BaseMapper<CategoryDO> {

    /**
     * 判断分类名是否存在
     * @param id 更新场景下需要排除当前主键对应的分类名
     * @param name 分类名
     * @return 是否存在
     */
    default Boolean nameExists(Long id, String name) {
        LambdaQueryWrapper<CategoryDO> wr = Wrappers.lambdaQuery(CategoryDO.class)
                .eq(CategoryDO::getName, name)
                .ne(id != null, CategoryDO::getId, id);
        return selectCount(wr) > 0;
    }

    default Boolean idExists(Long id) {
        return selectCount(
                Wrappers.lambdaQuery(CategoryDO.class).eq(CategoryDO::getId, id)
        ) > 0;
    }

    default Boolean childrenExists(Long pid) {
        return selectCount(
                Wrappers.lambdaQuery(CategoryDO.class).eq(CategoryDO::getPid, pid)
        ) > 0;
    }
}
