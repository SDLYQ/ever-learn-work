package com.ever.serviceorderribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * All rights Reserved
 *
 * @author xpr
 * @version V1.0.0
 * @projectName ever-learn-work
 * @title OrderController
 * @package com.ever.serviceorder.controller
 * @description 生产者
 * @date 2022/7/18 15:22
 * @copyright 2022
 */
@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 新增订单
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder(){
        System.out.println("订单新增成功");
        //调用库存扣减
        String apiReqResult = restTemplate.getForObject("http://service-order-stock/stock/subStock",String.class);
        return "订单服务-订单新增成功:" + apiReqResult;
    }
}
