package com.node12.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetMsgController {

    private static Logger LOG = LoggerFactory.getLogger(GetMsgController.class);

    @GetMapping("/feign/getMsg")
    public String getMsg (@RequestParam("param") String param) {
        LOG.info("v7.0.0-8002-"+param);
        return "8002-param-"+param ;
    }
    
}
