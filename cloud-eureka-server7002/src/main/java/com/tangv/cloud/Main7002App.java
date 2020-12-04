package com.tangv.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/12 9:02 上午
 */
@SpringBootApplication
@EnableEurekaServer
public class Main7002App {
    public static void main(String[] args) {
        SpringApplication.run(Main7002App.class,args);
    }
}
