package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.CommonResult;
import com.atguigu.springcloud.bean.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @FileName: PaymentController
 * @Author Steven
 * @Date: 2020/3/26
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    String serverPort;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "payment/create")
    public CommonResult createPayment(Payment payment){
        int result=paymentService.create(payment);
        log.info("******插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入数据库成功，serverPort:"+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败,ServePort:"+serverPort,null);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public  CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果结果："+payment);
        int age=100/2;
        if(payment!=null){
            return new CommonResult(200,"查询数据库成功,ServerPort:"+serverPort,payment);
        }else{
            return new CommonResult(444,"插入数据库失败"+id,null);
        }
    }

    @GetMapping(value = "payment/discover")
    public Object discover(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("********element:"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
