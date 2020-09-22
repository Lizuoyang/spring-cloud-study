package com.gudongcheng.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

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
@EnableCircuitBreaker
public class PayMentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentHystrixMain8001.class, args);
        log.info("========================================");
        log.info("==== Payment8001 Application Started ===");
        log.info("========================================");
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的坑
     * ServletRegistrationBean因为SpringBoot的默认路径不是 “/hystrix.stream"
     * 只要在自己的项目里配置上下的servlet就可以了
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet() ;
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return  registrationBean;
    }
}
