package com.order.userservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
 
@EnableEurekaClient //Eureka Client
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.order.userservice.dao.mapper")
@ComponentScan(basePackages = {"com.order.userservice.dao.mapper","com.order.userservice.service","com.order.userservice.service.impl","com.order.userservice.controller"})
public class UserAppMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserAppMain.class).web(true).run(args);
    }
}