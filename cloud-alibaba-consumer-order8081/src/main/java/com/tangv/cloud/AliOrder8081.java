package com.tangv.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * author:   tangwei
 * Date:     2021/3/28 22:05
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliOrder8081 {

    public static void main(String[] args) {
        SpringApplication.run(AliOrder8081.class, args);
    }

}