package com.tangv.cloud;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 7:11 下午
 */
@EnableAsync
@SpringBootApplication
@EnableEurekaClient
public class payment8001 {
    public static void main(String[] args) {
        SpringApplication.run(payment8001.class,args);
    }
}
