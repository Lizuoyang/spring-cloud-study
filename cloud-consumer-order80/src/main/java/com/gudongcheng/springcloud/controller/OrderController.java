package com.gudongcheng.springcloud.controller;

import com.gudongcheng.springcloud.common.ResponseMessage;
import com.gudongcheng.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    public static final String PROVIDER_PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public ResponseMessage create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PROVIDER_PAYMENT_URL + "/payment/create", payment, ResponseMessage.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public ResponseMessage get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PROVIDER_PAYMENT_URL + "/payment/get/" + id, ResponseMessage.class);
    }

    @GetMapping("/consumer/payment/list")
    public ResponseMessage list() {
        return restTemplate.getForObject(PROVIDER_PAYMENT_URL + "/payment/list", ResponseMessage.class);
    }
}
