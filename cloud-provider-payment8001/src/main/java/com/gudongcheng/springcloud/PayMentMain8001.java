package com.gudongcheng.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>
 *
 * </p>
 *
 * @package: com.gudongcheng.springcloud
 * @description:
 * @author: 月明
 * @date: Created in 2020/4/30 21:29
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
@SpringBootApplication
@Slf4j
@MapperScan("com.gudongcheng.springcloud.mapper")
@EnableEurekaClient
public class PayMentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8001.class, args);
        log.info("========================================");
        log.info("==== Payment8001 Application Started ===");
        log.info("========================================");
    }
}
