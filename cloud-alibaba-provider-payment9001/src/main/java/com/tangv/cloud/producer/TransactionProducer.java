package com.tangv.cloud.producer;

import com.tangv.cloud.listen.impl.TransactionListenerImpl;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

/**
 * author:   tangwei
 * Date:     2021/6/2 23:02
 * Description:
 */
@RestController
public class TransactionProducer {

    private static Logger logger = LoggerFactory.getLogger(TransactionProducer.class);

    @Resource
    private TransactionListener transactionListener;

    @GetMapping("/send")
    public void send() throws MQClientException, UnsupportedEncodingException {
        //用于接收rokcetMq回调的监听器接口
        //这里会实现执行订单本地事务，commit，rollback，回调查询等逻辑
        //TransactionListener transactionListener = new TransactionListenerImpl();
        //创建一个支持事务消息的producer
        TransactionMQProducer transactionProducer = new TransactionMQProducer("TANGV_PRODUCER");
        transactionProducer.setNamesrvAddr("192.168.68.128:9876");
        //指定一个线程，里面会包含一些线程
        //这个线程池中的线程就是用来处理RocketMQ回调你的请求的
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("TANGV_THREAD");
                        return thread;
                    }
                });
        //给事务消息生产者设置对应的线程池，负责执行rocketMQ回调请求
        transactionProducer.setExecutorService(executorService);
        //给事务消息生产者设置对应的回调函数
        transactionProducer.setTransactionListener(transactionListener);
        //启动这个事务消息生产者
        transactionProducer.start();
        Message message = new Message("PAYMENT_TOPIC","payment_tag", "payment_key","一条简单的事务消息，请注意接收".getBytes(RemotingHelper.DEFAULT_CHARSET));
        try {
            //将消息作为事务消息的模式发出去
            TransactionSendResult transactionSendResult = transactionProducer.sendMessageInTransaction(message, null);
        }catch (Exception e) {
            //half消息发送失败
            logger.error("【half消息发送失败，执行回滚】");
            TransactionSendResult transactionSendResult = transactionProducer.sendMessageInTransaction(message, null);
        }
    }

}