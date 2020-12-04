//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tangv.cloud.declare;

import java.time.LocalDateTime;

public interface IPojo {
    void setCreateTime(LocalDateTime var1);

    void setModifyTime(LocalDateTime var1);

    void prepareInsert();

    void prepareUpdate();
}
