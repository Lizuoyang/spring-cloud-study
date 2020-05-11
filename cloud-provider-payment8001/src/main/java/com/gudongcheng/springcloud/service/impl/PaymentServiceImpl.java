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
}
