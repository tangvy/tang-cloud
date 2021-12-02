package com.tangv.cloud.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * author:   tangwei
 * Date:     2021/10/16 11:09
 * Description: 产品
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 2436141310494111070L;

    private Long productId;

    private String productName;

    private BigDecimal productPrice;

    public Product(Long productId, String productName, BigDecimal productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}