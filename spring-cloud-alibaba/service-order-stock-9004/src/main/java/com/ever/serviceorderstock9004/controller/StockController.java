package com.ever.serviceorderstock9004.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved
 *
 * @author xpr
 * @version V1.0.0
 * @projectName ever-learn-work
 * @title StockController
 * @package com.ever.serviceorderstock.controller
 * @description 消费者
 * @date 2022/7/18 15:16
 * @copyright 2022
 */
@RestController
@RequestMapping("stock")
public class StockController {
    @Value("${server.port}")
    private String port;

    /**
     * 库存新增
     * @return
     */
    @RequestMapping("/addStock")
    public String addStock(){
        System.out.println("库存新增成功");

        return "库存服务-库存新增成功";
    }

    /**
     * 库存扣减
     * @return
     */
    @RequestMapping("/subStock")
    public String subStock(){
        System.out.println("库存扣减成功");

        return "库存服务-库存扣减成功 - 端口：" + port;
    }
}
