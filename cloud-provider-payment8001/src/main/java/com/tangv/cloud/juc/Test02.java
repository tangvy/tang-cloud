package com.tangv.cloud.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * author:   tangwei
 * Date:     2021/9/5 10:44
 * Description:
 */
@Slf4j
public class Test02 {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0;i < 5;i++) {
                print.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0;i < 5;i++) {
                print.printB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0;i < 5;i++) {
                print.printC();
            }
        }).start();
    }

    private static class Print {
        private int status = 1;

        public void printA() {
            synchronized (lock) {


                while (status != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                status = 2;
                lock.notifyAll();
            }
        }

        public void printB() {
            synchronized (lock) {
                while (status != 2) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                status = 3;
                lock.notifyAll();
            }
        }

        public void printC() {
            synchronized (lock) {
                while (status != 3) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                status = 1;
                lock.notifyAll();
            }
        }
    }
}