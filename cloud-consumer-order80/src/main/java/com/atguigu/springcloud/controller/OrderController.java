package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.CommonResult;
import com.atguigu.springcloud.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @FileName: OrderController
 * @Author Steven
 * @Date: 2020/3/31
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create/{serial}")
    public CommonResult<Payment> create(@PathVariable("serial") String serial,Payment payment){
        payment.setSerial(serial);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
