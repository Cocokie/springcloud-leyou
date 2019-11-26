package com.lix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableEurekaServer
public class EurekaServer10000_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer10000_App.class,args);
    }
}
