package com.seata.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("node11-seata-inventory")
public interface InventoryFeign {

    @GetMapping("/updateInventory")
    Integer updateInventory (@RequestParam("inventory") Integer inventory) ;
}
