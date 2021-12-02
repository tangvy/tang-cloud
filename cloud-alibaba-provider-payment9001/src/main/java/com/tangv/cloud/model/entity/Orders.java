package com.tangv.cloud.model.entity;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * author:   tangwei
 * Date:     2021/7/18 17:19
 * Description:
 */
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 5336718130116295124L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;

    private String description;

    public Orders(String orderCode, String desc) {
        this.orderCode = orderCode;
        this.description = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }
}