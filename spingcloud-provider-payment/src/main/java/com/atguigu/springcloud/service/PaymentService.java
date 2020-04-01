package com.atguigu.springcloud.service;

import com.atguigu.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @FileName: PaymentService
 * @Author Steven
 * @Date: 2020/3/26
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
