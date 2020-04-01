package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.bean.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @FileName: PaymentServiceImpl
 * @Author Steven
 * @Date: 2020/3/26
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {

        return  paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentMapper.getPaymentById(id);
    }
}
