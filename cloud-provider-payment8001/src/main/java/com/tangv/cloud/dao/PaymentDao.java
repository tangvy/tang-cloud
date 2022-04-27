package com.tangv.cloud.dao;

import com.tangv.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/7/9 8:02 下午
 */

@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
