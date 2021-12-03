package com.tangv.cloud.model;

import lombok.Data;

import java.io.Serializable;

/**
 * author:   tangwei
 * Date:     2021/12/2 23:34
 * Description:
 */
@Data
public class TOrder implements Serializable {

    private static final long serialVersionUID = 4995789883192748710L;

    private Integer orderId;

    private Integer userId;

    public TOrder(Integer orderId, Integer userId) {
        this.orderId = orderId;
        this.userId = userId;
    }
}