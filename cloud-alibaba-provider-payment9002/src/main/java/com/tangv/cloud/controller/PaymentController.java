package com.tangv.cloud.controller;

import com.tangv.cloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:   tangwei
 * Date:     2021/3/28 21:17
 * Description:
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/nacos/provider/get/{id}")
    public CommonResult<Integer> get(@PathVariable Long id) {
        return new CommonResult<>(200,"查询成功！", port);
    }

}