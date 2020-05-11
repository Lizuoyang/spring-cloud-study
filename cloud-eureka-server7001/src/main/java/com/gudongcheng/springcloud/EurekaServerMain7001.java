package com.gudongcheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 * Eureka Server 7001
 * </p>
 *
 * @package: com.gudongcheng.springcloud
 * @description:
 * @author: 月明
 * @date: Created in 2020/5/10 13:32
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified:
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain7001.class);
    }
}
