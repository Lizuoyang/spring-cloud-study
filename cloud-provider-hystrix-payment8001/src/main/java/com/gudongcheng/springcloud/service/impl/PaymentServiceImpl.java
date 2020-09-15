package com.gudongcheng.springcloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gudongcheng.springcloud.entities.Payment;
import com.gudongcheng.springcloud.mapper.PaymentMapper;
import com.gudongcheng.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.gudongcheng.springcloud.service
 * @description:
 * @author: 月明
 * @date: Created in 2020/5/1 22:04
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.selectById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public int update(Payment payment) {
        return paymentMapper.updateById(payment);
    }

    @Override
    public int deletePaymentById(Long id) {
        return paymentMapper.deleteById(id);
    }

    @Override
    public String hystrixOk(Integer id) {
        return "访问成功，线程名称：" + Thread.currentThread().getName() + ",id = " + id;
    }

    @Override
    public String hystrixTimeout(Integer id) {
        Integer seconds = 3000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "访问超时，线程名称：" + Thread.currentThread().getName() + ",id = " + id + ", 耗时： " + seconds / 1000;
    }
}
