package com.gudongcheng.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OrderMainZk80
 * @Description TODO
 * @Author LiZuoYang
 * @Date 2020/7/14 13:41
 **/
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class OrderMainZk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainZk80.class);
    }
}
