package com.ever.servicesentinelopenfeign.controller;

import com.ever.servicesentinelopenfeign.openfeign.StockOpenFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单服务
 * @author xpr
 * @create 2022/6/7
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    StockOpenFeignService stockOpenFeignService;
    /**
     * 下单
     * @return
     */
    @RequestMapping("/add")
    public String addOrder(){
        System.out.println("下单成功");
        //调用库存扣减
        String result = stockOpenFeignService.addStock();
        return "订单服务-订单新增成功:" + result;
    }
}
