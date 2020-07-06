package com.order.orderservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
 
@EnableEurekaClient //Eureka Client
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.order.orderservice.dao.mapper")
@ComponentScan(basePackages = {"com.order.orderservice.dao.mapper","com.order.orderservice.service","com.order.orderservice.service.impl","com.order.orderservice.controller"})
public class OrderAppMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(OrderAppMain.class).web(true).run(args);
    }
}