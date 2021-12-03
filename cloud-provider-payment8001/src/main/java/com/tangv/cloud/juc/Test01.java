package com.tangv.cloud.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:   tangwei
 * Date:     2021/9/3 22:25
 * Description:
 */
public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            System.out.println(Thread.currentThread() + ":" + "before await");
            try {
                //condition.await();
                System.out.println(Thread.currentThread() + ":" + "after await");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        /*Thread.sleep(1000);
        lock.lock();
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread() + ":" + "before signal");
            condition.signal();
            System.out.println(Thread.currentThread() + ":" + "after signal");
        } finally {
            lock.unlock();
        }*/
    }
}