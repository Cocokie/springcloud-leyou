package com.lix;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "com.lix.mapper")
public class ItemService8001_App {
    public static void main(String[] args) {
        SpringApplication.run(ItemService8001_App.class,args);
    }
}
