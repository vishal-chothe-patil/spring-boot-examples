package com.killerexpertise.zuulapi.getwayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulApiGatewayServerApplication {

    public static void main(String[] args) {

        System.out.println("Zuul API Gateway Server is getting Started!");

        SpringApplication.run(ZuulApiGatewayServerApplication.class, args);

        System.out.println("Zuul API Gateway Server is up and running!");

    }

}
