package com.mall.domain.entity;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mall.domain.BaseDO;
import com.myboy.sql.annotation.Column;
import com.myboy.sql.annotation.Index;
import com.myboy.sql.annotation.Table;
import com.myboy.sql.constant.IndexEnum;
import lombok.Data;

@Data
@Table(name = "file_detail", comment = "文件信息表")
@TableName("file_detail")
public class FileDetailDO extends BaseDO {

    @Index(name = "idx_file_detail_file_name_md5", type = IndexEnum.UNIQUE, fields = {"file_name", "file_md5", "del_flag"})
    @Column(comment = "文件名称")
    private String fileName;

    @Column(comment = "文件md5")
    private String fileMd5;

    @Column(comment = "分片数")
    private Integer partNum;

    @Column(comment = "上传id，minio一个文件分片上传唯一id", len = 200)
    private String uploadId;

    @Column(comment = "是否完成上传", defaultVal = "0")
    private Boolean isFinishUpload;

    public String genDownloadUrl() {
        return StrUtil.format("{}/{}/{}",
                SpringUtil.getProperty("minio.end-point"),
                SpringUtil.getProperty("minio.bucket"),
                minioFileName()
        );
    }

    public String minioFileName() {
        return fileMd5 + "-" + fileName;
    }
}
