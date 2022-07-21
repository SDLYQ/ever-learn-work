package com.ever.servicesentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 新增订单
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder(){
        System.out.println("订单新增成功");

        return "订单服务-订单新增成功";
    }

    /**
     * 退单
     * @return
     */
    @RequestMapping("/subOrder")
    public String subOrder(){
        System.out.println("退单成功");
        int a = 3/0;
        return "订单服务-订单新增成功";
    }

    /**
     * 新增订单
     * @return
     */
    @RequestMapping("/detail")
    @SentinelResource(value = "detail",blockHandler = "deal_detail")
    public String detail(@RequestParam(value = "id") String id){
        System.out.println("订单详情："+id);

        return "订单服务-订单详情："+id;
    }

    //兜底方法
    public String deal_detail(String id, BlockException blockException){
        return "deal_testHotKey,o(╥﹏╥)o";
    }
}

