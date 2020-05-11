package com.gudongcheng.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gudongcheng.springcloud.entities.Payment;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.gudongcheng.springcloud.service
 * @description:
 * @author: 月明
 * @date: Created in 2020/5/1 22:00
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
public interface PaymentService extends IService<Payment> {
    /**
     * 根据ID查询
     * @return com.gudongcheng.springcloud.entities.Payment
     * @exception 
     * @author Zero_Li
     * @date 2020/5/1 22:02 
     * @param id
     **/
    Payment getPaymentById(Long id);

    /**
     * 新增
     * @return void
     * @exception 
     * @author Zero_Li
     * @date 2020/5/1 22:02 
     * @param payment
     **/
    int create(Payment payment);

    /**
     * 修改
     * @return void
     * @exception
     * @author Zero_Li
     * @date 2020/5/1 22:02
     * @param payment
     **/
    int update(Payment payment);

    /**
     * 根据ID删除
     * @return int
     * @exception
     * @author Zero_Li
     * @date 2020/5/1 22:04
     * @param id
     **/
    int deletePaymentById(Long id);



}
