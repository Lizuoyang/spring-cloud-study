package com.gudongcheng.springcloud.feign;

import com.gudongcheng.springcloud.feign.fallback.PaymentFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE",fallback = PaymentFeignServiceFallback.class)
public interface PaymentFeignService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String hystrixOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String hystrixTimeout(@PathVariable("id")Integer id);
}
