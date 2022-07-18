package com.ever.serviceorderopenfeign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.UUID;

/**
 * All rights Reserved
 *
 * @author xpr
 * @version V1.0.0
 * @projectName ever-learn-work
 * @title CustomFeignInterceptor
 * @package com.ever.serviceorderopenfeign.interceptor
 * @description 拦截器
 * @date 2022/7/18 17:59
 * @copyright 2022
 */
public class CustomFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //写一些自己的业务逻辑 带上token 什么之类的
        System.out.println("执行openFeign自定义拦截器");
        String access_token = UUID.randomUUID().toString();
        requestTemplate.header("Authorization",access_token);//设置认证
    }
}
