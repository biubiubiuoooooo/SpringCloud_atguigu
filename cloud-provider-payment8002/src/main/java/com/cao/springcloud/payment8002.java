package com.cao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class payment8002 {

    public static void main(String[] args) {
        SpringApplication.run(payment8002.class, args);
    }
}
