package com.tangv.cloud.collections;

import lombok.extern.slf4j.Slf4j;

/**
 * author:   tangwei
 * Date:     2021/8/29 13:16
 * Description:
 */
//@Slf4j
public class TestVolatile {

    public static int finished = 0;

    private static void checked() {
        while (finished == 0) {
            //log.debug("=>未完成");
            System.out.println("=>未完成");
        }
        //log.debug("已完成");
        System.out.println("已完成");
    }

    private static void finished() {
        finished = 1;
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> checked()).start();
        Thread.sleep(100);
        finished();
        //log.debug("=>main方法结束");
        System.out.println("=>main方法结束");
    }

}