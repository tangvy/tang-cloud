package com.tangv.cloud.service;

import com.tangv.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 8:25 下午
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> getAll();

    public void exportPayment();

}
