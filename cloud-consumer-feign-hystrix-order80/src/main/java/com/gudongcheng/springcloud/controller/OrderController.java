package com.gudongcheng.springcloud.controller;

import com.gudongcheng.springcloud.common.ResponseMessage;
import com.gudongcheng.springcloud.entities.Payment;
import com.gudongcheng.springcloud.feign.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.gudongcheng.springcloud.controller
 * @description:
 * @author: 月明
 * @date: Created in 2020/5/5 22:31
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
@RestController
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @PostMapping("/consumer/payment/create")
    public ResponseMessage create(@RequestBody Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public ResponseMessage get(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }

    @GetMapping("/consumer/payment/list")
    public ResponseMessage list() {
        return paymentFeignService.list();
    }

    @GetMapping("/consumer/payment/timeout")
    public ResponseMessage timeout() {
        return paymentFeignService.timeout();
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String hystrixTimeout(@PathVariable Integer id) {
        return paymentFeignService.hystrixTimeout(id);
    }

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable Integer id) {
        return paymentFeignService.hystrixOk(id);
    }
}
