package com.mall.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.myboy.sql.annotation.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDO {

    @TableId(type = IdType.ASSIGN_ID)
    @Column(comment = "id", isKey = true)
    private Long id;

    @Column(comment = "创建时间")
    private LocalDateTime createTime;

    @Column(comment = "修改时间")
    private LocalDateTime updateTime;

    @Column(comment = "删除标志")
    private Long delFlag;
}