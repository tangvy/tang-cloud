package com.tangv.cloud.controller;

import com.tangv.cloud.entities.CommonResult;
import com.tangv.cloud.entities.Payment;
import com.tangv.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 8:32 下午
 */

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);

        log.info("插入结果："+result);
        if (result>0) {
            return new CommonResult(200,"插入成功！serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败！",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("获取结果："+payment);
        if (payment != null) {
            return new CommonResult(200,"查询成功！serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录！",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getServiceId()+"\t"+instance.getHost()
            +instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

}
