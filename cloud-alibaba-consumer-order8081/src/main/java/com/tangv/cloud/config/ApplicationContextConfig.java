package com.tangv.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * author:   tangwei
 * Date:     2021/3/28 22:09
 * Description:
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * ribbon的负载均衡需要加注解
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}