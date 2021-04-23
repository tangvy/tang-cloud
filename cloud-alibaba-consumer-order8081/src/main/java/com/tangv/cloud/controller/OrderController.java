package com.tangv.cloud.controller;

import com.tangv.cloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private Integer port;

    @Value("${service-url.nacos-user-service}")
    private String paymentService;

    @Value("${name}")
    private String name;

    @GetMapping("/nacos/consumer/get/{id}")
    public CommonResult<Integer> get(@PathVariable Long id) {
        return restTemplate.getForObject(paymentService + "/nacos/provider/get/" + id,CommonResult.class);
    }

    @GetMapping("/get")
    public CommonResult<String> getName() {
        return new CommonResult(200, name);
    }

}