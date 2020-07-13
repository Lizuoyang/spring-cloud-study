package com.gudongcheng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ZkServer7003
 * @Description TODO
 * @Author LiZuoYang
 * @Date 2020/7/13 15:29
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZkServerMain7003 {
    public static void main(String[] args) {
        SpringApplication.run(ZkServerMain7003.class);
    }
}
