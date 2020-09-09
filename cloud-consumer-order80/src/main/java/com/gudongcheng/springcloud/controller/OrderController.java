package com.gudongcheng.springcloud.controller;

import com.gudongcheng.springcloud.common.ResponseMessage;
import com.gudongcheng.springcloud.entities.Payment;
import com.gudongcheng.springcloud.loadbalance.MyLoadbalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLoadbalanceService loadbalanceServicel;

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

    @GetMapping("/consumer/payment/loadbalance")
    public ResponseMessage loadbalance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return ResponseMessage.error("服务列表为空");
        }
        ServiceInstance serviceInstance = loadbalanceServicel.getInstance(instances);
        return restTemplate.getForObject(serviceInstance.getUri()+  "/payment/loadbalance", ResponseMessage.class);
    }
}
