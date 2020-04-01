package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @FileName: PaymentMapper
 * @Author Steven
 * @Date: 2020/3/26
 */
@Mapper
public interface PaymentMapper {

     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}
