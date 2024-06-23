package com.mall.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mall.domain.entity.FileDetailDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileDetailMapper extends BaseMapper<FileDetailDO> {

    default FileDetailDO findByNameMd5(String fileName, String md5) {
        LambdaQueryWrapper<FileDetailDO> wr = Wrappers.lambdaQuery(FileDetailDO.class)
                .eq(FileDetailDO::getFileName, fileName)
                .eq(FileDetailDO::getFileMd5, md5);
        return selectOne(wr);
    }

}