package com.gudongcheng.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 * 消费者订单主启动类
 * </p>
 *
 * @package: com.gudongcheng.springcloud
 * @description:
 * @author: 月明
 * @date: Created in 2020/5/5 22:29
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
        log.info("========================================");
        log.info("====== Order80 Application Started =====");
        log.info("========================================");
    }
}
