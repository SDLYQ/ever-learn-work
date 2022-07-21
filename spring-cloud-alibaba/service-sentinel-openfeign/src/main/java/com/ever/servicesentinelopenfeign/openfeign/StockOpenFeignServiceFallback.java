package com.ever.servicesentinelopenfeign.openfeign;

import org.springframework.stereotype.Component;

@Component
public class StockOpenFeignServiceFallback implements StockOpenFeignService{

    @Override
    public String subStock(String id) {
        return "subStock-服务降级了！";
    }

    @Override
    public String addStock() {
        return "addStock-服务降级了！";
    }
}
