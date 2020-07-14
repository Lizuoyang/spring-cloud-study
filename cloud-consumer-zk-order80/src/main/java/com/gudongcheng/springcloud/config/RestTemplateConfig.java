package com.gudongcheng.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateConfig
 * @Description resttemplate 配置类
 * @Author LiZuoYang
 * @Date 2020/7/14 13:41
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
