package com.ever.serviceconfig.controller;

/**
 * All rights Reserved
 *
 * @author xpr
 * @version V1.0.0
 * @projectName ever-learn-work
 * @title OrderController
 * @package com.ever.serviceconfig.controller
 * @description
 * @date 2022/7/18 23:46
 * @copyright 2022
 */

import com.ever.serviceconfig.openfeign.StockOpenFeignService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单服务
 */
@RestController
@RequestMapping("/order")
@RefreshScope //配置此类接口动态刷新
public class OrderController {

    @Resource
    private StockOpenFeignService stockOpenFeignService;

    @Value("${user.name}")
    public String username;

    @Value("${user.age}")
    private int age;

    /**
     * 新增订单
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder(){
        System.out.println("订单新增成功");
        //调用库存扣减
        String result = stockOpenFeignService.subStock();
        return "订单服务-订单新增成功:" + result + " --username：" + username +"--age:"+age;
    }
}
