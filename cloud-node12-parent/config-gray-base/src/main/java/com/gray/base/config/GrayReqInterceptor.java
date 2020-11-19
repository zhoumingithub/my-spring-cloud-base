package com.gray.base.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求拦截器
 */
@Component
public class GrayReqInterceptor implements RequestInterceptor {

    private static final String VERSION_KEY = "versionId" ;

    /**
     * 处理请求头参数携带问题
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        HttpServletRequest request =
                ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();

        String versionId = request.getHeader(VERSION_KEY);

        if (StringUtils.isNotEmpty(versionId)){
            requestTemplate.header(VERSION_KEY,versionId);
        }
    }
}
