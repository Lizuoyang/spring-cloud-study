package com.gudongcheng.springcloud.feign.fallback;

import com.gudongcheng.springcloud.feign.PaymentFeignService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceFallback implements PaymentFeignService {
    @Override
    public String hystrixOk(Integer id) {
        return "PaymentFeignServiceFallback --- fall back: hystrixOk /(ㄒoㄒ)/~~ " + id;
    }

    @Override
    public String hystrixTimeout(Integer id) {
        return "PaymentFeignServiceFallback --- fall back: hystrixTimeout /(ㄒoㄒ)/~~ " + id;
    }
}
