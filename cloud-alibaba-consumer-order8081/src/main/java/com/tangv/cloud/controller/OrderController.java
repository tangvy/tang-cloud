package com.tangv.cloud.controller;

import com.tangv.cloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * author:   tangwei
 * Date:     2021/3/28 22:10
 * Description:
 */
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private Integer port;

    @Value("${service-url.nacos-user-service}")
    private String paymentService;

    @GetMapping("/nacos/consumer/get/{id}")
    public CommonResult<Integer> get(@PathVariable Long id) {
        return restTemplate.getForObject(paymentService + "/nacos/provider/get/" + id,CommonResult.class);
    }

}