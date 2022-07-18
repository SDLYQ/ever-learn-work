package com.ever.serviceorderribbon;

import com.ever.serviceorderribbon.config.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@SpringBootApplication
@EnableDiscoveryClient//可加可不加，依版本而定，从Spring Cloud Edgware开始，@EnableDiscoveryClient可省略。只需加上相关依赖，并进行相应配置，即可将微服务注册到服务发现组件上。
//可配置多个  RibbonRuleConfig不能被@SpringBootApplication的@ComponentScan扫描到，所以把它放到上一层，否则就是全局配置的效果
@RibbonClients(value = {
        @RibbonClient(name = "service-stock-ribbon",configuration = RibbonRuleConfig.class)
})
public class ServiceOrderRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOrderRibbonApplication.class, args);
    }

}
