package com.ever.serviceorderopenfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceOrderOpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderOpenfeignApplication.class, args);
    }

}
