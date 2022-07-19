package com.ever.servicesentinelcore.controller;

/**
 * All rights Reserved
 *
 * @author xpr
 * @version V1.0.0
 * @projectName ever-learn-work
 * @title SentinelController2
 * @package com.ever.servicesentinelcore.controller
 * @description
 * @date 2022/7/19 11:21
 * @copyright 2022
 */

import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.ever.servicesentinelcore.pojo.User;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Sentinel接口流控测试
 */
@RestController
public class SentinelController3 {
    public static final String DEGRADE_RESOURCE_NAME = "degrade";//降级资源名
    /**
     * 定义服务降级规则
     *
     * spring的初始化方法
     */
    @PostConstruct
    private static void initDegradeRules(){
        //降级规则
        List<DegradeRule> DegradeRules = new ArrayList<>();
        //流控
        DegradeRule degradeRule = new DegradeRule();
        //设置受保护的资源
        degradeRule.setResource(DEGRADE_RESOURCE_NAME);
        // 设置规则测率： 异常数
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        //设置异常数
        degradeRule.setCount(2);
        degradeRule.setTimeWindow(10);//10秒内发生的异常
        degradeRule.setMinRequestAmount(2);//最小请求数

        DegradeRules.add(degradeRule);
        //加载配置好的规则
        DegradeRuleManager.loadRules(DegradeRules);
    }

    @RequestMapping("/degrade")
    @SentinelResource(value = DEGRADE_RESOURCE_NAME,entryType = EntryType.IN,blockHandler = "blockHandlerForDegrade")
    public User degrade(String id) throws InternalException {
        // 异常数/比例
        throw new RuntimeException("异常");

        //慢调用比例
        /*TimeUnit.SECONDS.sleep(1);
        return new User("正常");*/
    }
    /**
     * degrade服务降级的处理方法
     *
     * @param id
     * @param ex
     * @return
     */
    public User blockHandlerForDegrade(String id,BlockException ex){
        ex.printStackTrace();
        return new User("降级处理！");
    }
}
