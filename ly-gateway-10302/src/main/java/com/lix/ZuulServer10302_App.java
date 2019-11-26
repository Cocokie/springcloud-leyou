package com.lix;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringCloudApplication
@EnableZuulProxy
public class ZuulServer10302_App {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServer10302_App.class,args);
    }
}
