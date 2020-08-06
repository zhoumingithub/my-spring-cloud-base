package com.cloud.dubbo.controller;

import com.cloud.dubbo.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboWeb {

    @Reference
    private DubboService dubboService ;

    @GetMapping("/getInfo")
    public String getInfo () {
        return dubboService.getInfo() ;
    }
}
