package com.tangv.cloud.model;

import lombok.Data;

/**
 * author:   tangwei
 * Date:     2021/8/22 10:14
 * Description:
 */
@Data
public class Goods {
    private String code;

    public Goods(String code) {
        this.code = code;
    }
}