package com.tangv.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 9:28 下午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Order8080 {
    public static void main(String[] args) {
        SpringApplication.run(Order8080.class,args);
    }
}
