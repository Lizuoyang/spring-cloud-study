package com.gudongcheng.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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

    public static final String PROVIDER_PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String create() {
        return restTemplate.getForObject(PROVIDER_PAYMENT_URL + "/payment/zk", String.class);
    }
}
