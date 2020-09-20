package com.gudongcheng.springcloud.controller;

import com.gudongcheng.springcloud.common.ResponseMessage;
import com.gudongcheng.springcloud.entities.Payment;
import com.gudongcheng.springcloud.feign.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "paymentDefaultFallback")
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

    @HystrixCommand(fallbackMethod = "hystrixTimeoutFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String hystrixTimeout(@PathVariable Integer id) {
        return paymentFeignService.hystrixTimeout(id);
    }

    public String hystrixTimeoutFallback(@PathVariable Integer id) {
        return "8001支付服务系统超时或者系统报错，/(ㄒoㄒ)/~~, id = " + id;
    }

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String hystrixOk(@PathVariable Integer id) {
        int number = 10 / 0;
        return paymentFeignService.hystrixOk(id);
    }

    public String paymentDefaultFallback() {
        return "Hystrix 全局异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
