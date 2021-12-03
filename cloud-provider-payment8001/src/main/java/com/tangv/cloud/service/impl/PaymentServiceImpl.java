package com.tangv.cloud.service.impl;

import com.tangv.cloud.dao.PaymentDao;
import com.tangv.cloud.entities.Payment;
import com.tangv.cloud.model.Goods;
import com.tangv.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 8:25 下午
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getAll() {
        return paymentDao.getAll();
    }

    @Override
    public void exportPayment() {
        List<Payment> paymentList = this.getAll();
    }

    public static void main(String[] args) {
        Map<String, List<Goods>> map = new HashMap<>();
        List<Goods> originList = new ArrayList<>(1);
        originList.add(new Goods("1"));
        map.put("a", originList);
        System.out.println("map:" + map);
        Map<String, List<Goods>> newMap = new HashMap<>();
        Set<Map.Entry<String, List<Goods>>> entries = map.entrySet();
        Iterator<Map.Entry<String, List<Goods>>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Goods>> next = iterator.next();
            newMap.put(next.getKey(), next.getValue());
        }
        System.out.println("newMap:" + newMap);
        List<Goods> list = newMap.get("a");
        List<Goods> resultList = new ArrayList<>();
        Iterator<Goods> iteratorList = originList.iterator();
        while (iteratorList.hasNext()) {
            Goods next = iteratorList.next();
            resultList.add(next);
        }
        resultList.add(new Goods("5"));
        System.out.println("result：" + resultList);
        System.out.println("");
        newMap.put("a", resultList);
        System.out.println("map:" + map);
        System.out.println("newMap:" + newMap);
        /*List<Integer> list = map.get("a");
        list.add(4);
        System.out.println("map:" + map);
        System.out.println("originList:" + originList);
        List<Integer> resultList = new ArrayList<>();
        Iterator<Integer> iterator = originList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            resultList.add(next);
        }
        System.out.println("result：" + resultList);
        resultList.add(5);
        System.out.println("orginList:" + originList + ";resultList:" + resultList);*/
    }

    @Async
    public void interrupt() {
        log.info("===开始执行异步任务===>>，当前线程：{}，时间：{}", Thread.currentThread().getId(), LocalDateTime.now().toString());
        try {
            Thread.sleep(5000);
            log.info("===异步任务执行完毕===，当前线程：{}，时间：{}", Thread.currentThread().getName(), LocalDateTime.now().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
