package com.tangv.cloud.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * author:   tangwei
 * Date:     2021/10/16 11:17
 * Description: 产品生产者
 */
public class ProductProducer implements Serializable, Runnable {

    private static final long serialVersionUID = -3426941829341600103L;

    private ProductFactory productFactory;

    private AtomicLong atomicLong = new AtomicLong(1);

    private final int MAX_COUNT = 100;

    public ProductProducer(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    @Override
    public void run() {
        for (int i = 0;i < MAX_COUNT;i++) {
            productFactory.put(createProduct());
        }
    }

    private Product createProduct() {
        Product product = new Product(atomicLong.get(), Thread.currentThread().getName(), BigDecimal.valueOf(atomicLong.get()*10L));
        System.out.println("生产者 ：" + Thread.currentThread().getName() + "生产产品 ==> " + product.toString());
        atomicLong.addAndGet(1);
        return product;
    }
}