package com.atguigu.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @FileName: Payment
 * @Author Steven
 * @Date: 2020/3/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable{

    private Long id;
    private String serial;
}
