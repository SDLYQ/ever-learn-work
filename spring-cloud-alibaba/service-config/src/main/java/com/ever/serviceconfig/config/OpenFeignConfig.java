package com.ever.serviceconfig.config;

import com.ever.serviceconfig.interceptor.CustomFeignInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局配置：当使用@Configuration 会将配置作用所有的服务提供方
 * 局部配置：如果只想针对某一个服务进行配置，就不要加@Configuration
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

//    /**
//     * 修改契约配置，支持Feign原生的注解
//     * @return
//     */
//    @Bean
//    public Contract feignContract(){
//        return new Contract.Default();
//    }

    /**
     * 超时时间配置
     * @return
     */
    @Bean
    public Request.Options options(){
        return new Request.Options(1000,3000);
    }

    /**
     * 自定义feign拦截器
     * @return
     */
    @Bean
    public CustomFeignInterceptor customFeignInterceptor() {
        return new CustomFeignInterceptor();
    }

}
