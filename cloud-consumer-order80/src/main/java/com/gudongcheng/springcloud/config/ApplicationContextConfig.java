package com.gudongcheng.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * 应用程序配置类
 * </p>
 *
 * @package: com.gudongcheng.springcloud.config
 * @description:
 * @author: 月明
 * @date: Created in 2020/5/5 22:31
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
