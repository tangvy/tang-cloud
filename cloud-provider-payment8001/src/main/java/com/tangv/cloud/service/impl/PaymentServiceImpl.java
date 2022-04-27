package com.tangv.cloud.service.impl;

import com.tangv.cloud.dao.PaymentDao;
import com.tangv.cloud.entities.Payment;
import com.tangv.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 8:25 下午
 */

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
}
