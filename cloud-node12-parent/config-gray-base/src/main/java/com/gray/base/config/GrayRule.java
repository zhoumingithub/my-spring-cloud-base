package com.gray.base.config;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Configuration
public class GrayRule extends ZoneAvoidanceRule {

    @Bean
    public GrayReqInterceptor grayReqInterceptor(){
        return new GrayReqInterceptor();
    }

    private static final String VERSION_KEY = "versionId" ;

    @Override
    public Server choose(Object key) {

        HttpServletRequest request =
                ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();

        String versionId = request.getHeader(VERSION_KEY);

        // 服务匹配
        List<Server> serverList = this.getPredicate().getEligibleServers(this.getLoadBalancer().getAllServers(), key);
        Server toServer = getServer(serverList,versionId);
        if (toServer != null){
            return toServer ;
        } else {
            return getServer(serverList,GrayConstant.VERSION_DEF);
        }
    }

    private Server getServer (List<Server> serverList,String version){
        Server toServer = null ;
        for (Server server : serverList) {
            Map<String, String> metadata = ((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata();

            String metaVersion = metadata.get("version");
            if (!StringUtils.isEmpty(metaVersion)) {
                if (metaVersion.equals(version)) {
                    toServer = server;
                }
            }
        }
        return toServer ;
    }
}
