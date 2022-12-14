package com.cao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther zzyy
 * @create 2020-02-22 11:56
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8802
{
    public static void main(String[] args)
    {
        SpringApplication.run(StreamMQMain8802.class,args);
    }
}
