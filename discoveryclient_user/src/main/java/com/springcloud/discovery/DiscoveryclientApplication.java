package com.springcloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.springcloud.discovery.controller","com.springcloud.discovery.config","com.springcloud.discovery.repository"})
public class DiscoveryclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryclientApplication.class, args);
    }

}
