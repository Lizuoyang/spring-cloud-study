package com.gudongcheng.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadbalanceService {
    /**
     * 获取执行的服务实例
     * @param instances
     * @return
     */
    ServiceInstance getInstance(List<ServiceInstance> instances);
}
