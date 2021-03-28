package com.tangv.cloud.clients;

import com.tangv.cloud.entities.CommonResult;
import com.tangv.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * author:   tangwei
 * Date:     2021/3/28 11:07
 * Description:
 */
@Component
@FeignClient("cloud-payment-service")
public interface PaymentClient {

    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id);
}