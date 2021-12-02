package com.tangv.cloud.listen.impl;

import com.tangv.cloud.model.entity.Orders;
import com.tangv.cloud.service.OrderService;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author:   tangwei
 * Date:     2021/6/2 23:03
 * Description:
 */
@Service
public class TransactionListenerImpl implements TransactionListener {

    private Logger logger = LoggerFactory.getLogger(TransactionListenerImpl.class);

    @Autowired
    private OrderService orderService;

    /**
     * 如果事务消息发送成功了，
     * 就会在这里回调你的这个函数，你就可以执行本地事务了
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        /**
         * 执行本地事务，根据一连串本地事务执行结果，决定commit or rollback
         */
        try {
            //如果本地事务执行成功，返回commit
            orderService.insert(new Orders("DD-20210718001", "第一条订单"));
            System.out.println(4/0);
            logger.debug("【接收到half消息，执行本地事务】------本地事务执行成功");
            return LocalTransactionState.COMMIT_MESSAGE;
        } catch (Exception e) {
            logger.error("【本地事务执行失败】",e);
            
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        messageExt.getTransactionId();
        return null;
    }
}