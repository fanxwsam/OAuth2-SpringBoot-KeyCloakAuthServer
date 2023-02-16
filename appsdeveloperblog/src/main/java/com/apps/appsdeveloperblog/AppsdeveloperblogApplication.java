package com.apps.appsdeveloperblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AppsdeveloperblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppsdeveloperblogApplication.class, args);
    }

}
