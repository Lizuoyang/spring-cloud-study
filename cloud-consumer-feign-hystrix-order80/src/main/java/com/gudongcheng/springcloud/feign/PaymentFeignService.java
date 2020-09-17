package com.gudongcheng.springcloud.feign;

import com.gudongcheng.springcloud.common.ResponseMessage;
import com.gudongcheng.springcloud.config.FeignConfig;
import com.gudongcheng.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE",configuration = FeignConfig.class)
@RequestMapping("/payment")
public interface PaymentFeignService {

    @PostMapping("/create")
    ResponseMessage create(@RequestBody Payment payment);

    @GetMapping("/get/{id}")
    ResponseMessage get(@PathVariable("id") Long id);

    @GetMapping("/list")
    ResponseMessage list();

    @GetMapping("/feign/timeout")
    ResponseMessage timeout();

    @GetMapping("/hystrix/ok/{id}")
    String hystrixOk(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/timeout/{id}")
    String hystrixTimeout(@PathVariable("id")Integer id);
}
