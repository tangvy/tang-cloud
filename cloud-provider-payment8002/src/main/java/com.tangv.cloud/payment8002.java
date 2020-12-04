package com.tangv.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 7:11 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class payment8002 {
    public static void main(String[] args) {
        SpringApplication.run(payment8002.class,args);
    }
}
