package com.tangv.cloud.service;

import org.apache.rocketmq.client.producer.LocalTransactionExecuter;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:   tangwei
 * Date:     2021/7/18 17:52
 * Description:
 */
@Service
public class OrderExecuter implements LocalTransactionExecuter {

    @Autowired
    private OrderService orderService;

    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message message, Object o) {
        //orderService.insert(new Order("DD-20210718001", "第一条订单"));
        System.out.println(4/0);
        return null;
    }
}