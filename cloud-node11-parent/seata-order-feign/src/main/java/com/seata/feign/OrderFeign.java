package com.seata.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("node11-seata-order")
public interface OrderFeign {

    @GetMapping("/createOrder")
    Integer createOrder (@RequestParam("orderNo") String orderNo) ;
}
