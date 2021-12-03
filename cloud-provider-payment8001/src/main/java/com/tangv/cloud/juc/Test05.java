package com.tangv.cloud.juc;

import java.util.concurrent.CountDownLatch;

/**
 * author:   tangwei
 * Date:     2021/9/5 17:13
 * Description:
 */
public class Test05 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始》》");
            System.out.println(Thread.currentThread().getName() + "结束》》");
            countDownLatch.countDown();
        }).start();
        for (int i = 0;i<2;i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "开始》》");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束》》");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }
}