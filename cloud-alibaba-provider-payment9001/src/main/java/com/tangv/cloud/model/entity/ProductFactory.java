package com.tangv.cloud.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * author:   tangwei
 * Date:     2021/10/16 11:15
 * Description: 产品工厂
 */
public class ProductFactory implements Serializable {

    private static final long serialVersionUID = -1039208390701364628L;

    private BlockingQueue<Product> productList = new ArrayBlockingQueue<>(15);

    private final Object productLock = new Object();

    private final int MAX_CAPCITY = 15;

    public void put(Product product) {
        synchronized (productLock) {
            while (productList.size() == MAX_CAPCITY) {
                try {
                    productLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            productList.add(product);
            productLock.notifyAll();
        }
    }

    public Product get() {
        Product product =null;
        synchronized (productLock) {
            while (productList.size() == 0) {
                try {
                    productLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                product = productList.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //product = productList.remove(productList.size() - 1);
            productLock.notifyAll();
        }
        return product;
    }
}