package com.lix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UpLoadService8088_App {
    public static void main(String[] args) {
        SpringApplication.run(UpLoadService8088_App.class);
    }
}
