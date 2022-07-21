package com.ever.servicesentinelopenfeign.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 库存服务接口
 * name:指定调用rest接口所对应的服务名
 * path:指定调用rest接口所在的StockController指定的@RequestMapping
 */
@FeignClient(name = "service-order-stock",path = "stock",fallback = StockOpenFeignServiceFallback.class)
public interface StockOpenFeignService {

    //声明需要调用的rest接口对应的方法
    /**
     * 库存扣减
     * @return
     */
    @RequestMapping("/subStock/{id}")
    //@RequestLine("GET /subStock") //feign的原生注解
    String subStock(@PathVariable("id") String id);
    //String subStock(@Param("id") String id); //@PathVariable换成@Param

    /**
     * 库存新增
     * @return
     */
    @RequestMapping("/addStock")
    //@RequestLine("GET /addStock") //feign的原生注解
    String addStock();
}
