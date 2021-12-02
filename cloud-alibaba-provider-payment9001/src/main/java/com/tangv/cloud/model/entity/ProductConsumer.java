package com.tangv.cloud.model.entity;

import java.io.Serializable;

/**
 * author:   tangwei
 * Date:     2021/10/16 11:18
 * Description: 产品消费者
 */
public class ProductConsumer implements Serializable, Runnable {

    private static final long serialVersionUID = -4663792577863672207L;

    private ProductFactory productFactory;

    public ProductConsumer(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public void run() {
        while (true) {
            Product product = productFactory.get();
            System.out.println("消费者 ：产品" + product.getProductId() + "已被消费");
        }
    }
}