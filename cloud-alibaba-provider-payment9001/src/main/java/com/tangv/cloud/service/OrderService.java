package com.tangv.cloud.service;

import com.tangv.cloud.mapper.OrderMapper;
import com.tangv.cloud.model.entity.Orders;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author:   tangwei
 * Date:     2021/7/18 17:37
 * Description:
 */
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public Integer insert(Orders orders) {
        return orderMapper.insert(orders);
    }

    public Integer delete(Orders orders) {
        return orderMapper.delete(orders);
    }
}