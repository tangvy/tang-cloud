package com.tangv.cloud.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * author:   tangwei
 * Date:     2021/6/1 22:36
 * Description:
 */
public class SimpleMqProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("TANGV_PRODUCER");
        producer.setNamesrvAddr("192.168.68.128:9876");
        try {
            producer.start();
            producer.send(new Message("PAYMENT_TOPIC", "TAG_B", "例如1999年，作为民主党党魁的克林顿执政时期，曾发生过美国轰炸我国驻南斯拉夫使馆的恶劣事件；2016年奥巴马执政时期，美国政府搞了个荒谬至极的“南海仲裁案”。".getBytes()));
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        }
    }
}