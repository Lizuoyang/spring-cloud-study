package com.gudongcheng.springcloud.loadbalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class MyLoadbalanceImpl implements MyLoadbalanceService{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;

        } while (!this.atomicInteger.compareAndSet(current,next));
        log.info("第{}次访问",next);
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        int index = getAndIncrement() % instances.size();
        return instances.get(index);
    }
}
