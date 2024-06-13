package com.mall.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.myboy.sql.annotation.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDO extends Model<BaseDO> {

    @TableId(type = IdType.ASSIGN_ID)
    @Column(comment = "id", isKey = true)
    private Long id;

    @Column(defaultVal = "CURRENT_TIMESTAMP", comment = "创建时间")
    private LocalDateTime createTime;

    @Column(defaultVal = "CURRENT_TIMESTAMP", onUpdate = "CURRENT_TIMESTAMP", comment = "修改时间")
    private LocalDateTime updateTime;

    @TableLogic
    @Column(defaultVal = "0", comment = "删除标志")
    private Long delFlag;
}