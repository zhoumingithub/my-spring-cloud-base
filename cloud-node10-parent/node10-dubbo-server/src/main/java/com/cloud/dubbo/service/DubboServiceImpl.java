package com.cloud.dubbo.service;

import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DubboServiceImpl implements DubboService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboServiceImpl.class) ;

    @Override
    public String getInfo() {
        LOGGER.info("node10-dubbo-server start ...");
        return "node10-dubbo-server";
    }
}
