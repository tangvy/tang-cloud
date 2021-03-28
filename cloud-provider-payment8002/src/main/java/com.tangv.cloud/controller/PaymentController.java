package com.tangv.cloud.controller;

import com.tangv.cloud.entities.CommonResult;
import com.tangv.cloud.entities.Payment;
import com.tangv.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 8:32 下午
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if (result>0) {
            return new CommonResult(200,"插入成功！,server port:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败！,server port:"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("插入结果："+payment);
            if (payment != null) {
            return new CommonResult(200,"查询成功！,server port:"+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录！,server port:"+serverPort,null);
        }
    }

}
