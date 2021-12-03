package com.tangv.cloud.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:   tangwei
 * Date:     2021/9/5 11:05
 * Description:
 */
public class Test03 {

    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0;i<5;i++) {
                print.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0;i<5;i++) {
                print.printB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0;i<5;i++) {
                print.printC();
            }
        }).start();
    }

    private static class Print {
        private static volatile int status = 1;
        private ReentrantLock lock = new ReentrantLock();
        private Condition printAcondition = lock.newCondition();
        private Condition printBcondition = lock.newCondition();
        private Condition printCcondition = lock.newCondition();

        public void printA() {
            lock.lock();
            try {
                while (status != 1) {
                    printAcondition.await();
                }
                    System.out.print("A");
                    status = 2;
                    printBcondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printB() {
            lock.lock();
            try {
                while (status != 2) {
                    printBcondition.await();
                }
                    System.out.print("B");
                    status = 3;
                    printCcondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void printC() {
            lock.lock();
            try {
                while (status != 3) {
                    printCcondition.await();
                }
                    System.out.println("C");
                    status = 1;
                    printAcondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}