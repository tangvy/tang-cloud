package com.tangv.cloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/zk")
    public String zk() {
        return "springCloud with zookeeper；" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
