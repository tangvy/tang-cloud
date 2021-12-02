package com.tangv.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tangv.cloud.entities.CommonResult;
import com.tangv.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * author:   tangwei
 * Date:     2021/3/28 21:17
 * Description:
 */
@RestController
public class PaymentController {

    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/nacos/provider/get/{id}")
    @SentinelResource(value = "get", blockHandler = "handle")
    public CommonResult<Integer> get(@PathVariable Long id) {
        int i = 10 / 0;
        return new CommonResult<>(200,"查询成功！", port);
    }

    public CommonResult<String> handle(Long id, BlockException blockException) {
        return new CommonResult<>(500, "请求失败！", "出大麻烦啦！！！！！");
    }

}