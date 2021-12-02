package com.tangv.cloud.tests;

import com.tangv.cloud.model.entity.ProductConsumer;
import com.tangv.cloud.model.entity.ProductFactory;
import com.tangv.cloud.model.entity.ProductProducer;

/**
 * author:   tangwei
 * Date:     2021/10/16 11:45
 * Description:
 */
public class Test01 {

    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();
        new Thread(new ProductProducer(productFactory)).start();
        new Thread(new ProductConsumer(productFactory)).start();
    }
}