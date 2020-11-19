package com.node12.cloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("node12-server")
public interface GetMsgClient {

    @GetMapping("/feign/getMsg")
    String getMsg (@RequestParam("param") String param) ;

}
