package com.tangv.cloud.entities;

import com.tangv.cloud.declare.IPojo;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/9/12 10:00 下午
 */
@Data
public abstract class BasePojo implements IPojo {

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    public void setCreateTime(LocalDateTime createTime) {
        this.setCreateTime(createTime);
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.setModifyTime(modifyTime);
    }

    @Override
    public void prepareInsert() {
        this.setCreateTime(LocalDateTime.now());
        this.setModifyTime(LocalDateTime.now());
    }

    @Override
    public void prepareUpdate() {
        this.setModifyTime(LocalDateTime.now());
    }
}
