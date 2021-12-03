package com.tangv.cloud.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * author:   tangwei
 * Date:     2021/9/5 12:51
 * Description:
 */
public class Test04 {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0;i < 10;i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "start>>");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
                System.out.println(Thread.currentThread().getName() + "end==");
            }).start();
        }
    }
}