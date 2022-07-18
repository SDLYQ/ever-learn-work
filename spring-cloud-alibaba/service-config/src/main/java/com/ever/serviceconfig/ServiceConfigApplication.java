package com.ever.serviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient//可加可不加，依版本而定，从Spring Cloud Edgware开始，@EnableDiscoveryClient可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
@EnableFeignClients
public class ServiceConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        //SpringApplication.run(ServiceNacosconfigApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ServiceConfigApplication.class, args);
//        while(true) {
//            //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
//            String userName = applicationContext.getEnvironment().getProperty("user.name");
//            String userAge = applicationContext.getEnvironment().getProperty("user.age");
//            System.err.println("user name :" + userName + "; age: " + userAge);
//            TimeUnit.SECONDS.sleep(1);
//        }
    }
}
