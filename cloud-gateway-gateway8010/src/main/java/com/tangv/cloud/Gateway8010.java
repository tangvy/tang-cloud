package com.tangv.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * author:   tangwei
 * Date:     2021/3/28 9:52
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway8010 {

    public static void main(String[] args) {
        SpringApplication.run(Gateway8010.class, args);
    }
}