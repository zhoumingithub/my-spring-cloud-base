package com.node12.cloud.controller;

import com.node12.cloud.GetMsgClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MsgController {

    private static Logger LOG = LoggerFactory.getLogger(MsgController.class);

    @Resource
    private GetMsgClient getMsgClient ;

    @GetMapping("/getMsg")
    public String getMsg (@RequestParam("param") String param) {
        LOG.info("param-8001-"+param);
        return getMsgClient.getMsg(param);
    }
}
