package com.order.productservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
 
@EnableEurekaClient //Eureka Client
@SpringBootApplication
@MapperScan("com.order.productservice.dao.mapper")
@ComponentScan(basePackages = {"com.order.productservice.dao.mapper","com.order.productservice.service","com.order.productservice.service.impl","com.order.productservice.controller"})
public class ProductAppMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ProductAppMain.class).web(true).run(args);
    }
}