package com.ever.servicesentinelcore.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved
 *
 * @author xpr
 * @version V1.0.0
 * @projectName ever-learn-work
 * @title SentinelAspectConfiguration
 * @package com.ever.servicesentinelcore.config
 * @description
 * @date 2022/7/19 11:18
 * @copyright 2022
 */
/**
 * 若您的应用使用了 Spring AOP（无论是 Spring Boot 还是传统 Spring 应用），
 * 您需要通过配置的方式将 SentinelResourceAspect 注册为一个 Spring Bean：
 */
@Configuration
public class SentinelAspectConfiguration {
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}
