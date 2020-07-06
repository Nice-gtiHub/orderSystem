package com.order.eureka.orderSystemEureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication //spring-boot 
@EnableEurekaServer // spring-cloud 
public class RegisterMain{
     public static void main(String [] args) {
    	 new SpringApplicationBuilder(RegisterMain.class).web(true).run(args);
     }
}
