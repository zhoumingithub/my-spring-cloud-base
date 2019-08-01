package cloud.node02.consume.controller;

import cloud.node02.consume.tool.ServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ConsumeController {

    @Autowired
    private RestTemplate restTemplate ;

    String server_name = "http://NODE02-PROVIDER" ;
    // http://localhost:8001/showInfo
    // {"主题：":"SpringCloud微服务框架","作者：":"知了一笑","时间：":"2019-07-28"}
    @RequestMapping("/showInfo")
    public String showInfo (){
        return restTemplate.getForObject(server_name+"/getInfo",String.class) ;
    }

    /**
     * 简单配置
     */
    @RequestMapping("/showInfo1")
    @HystrixCommand(fallbackMethod = "getDefaultInfo")
    public String showInfo1 (){
        return restTemplate.getForObject(server_name+"/getInfo",String.class) ;
    }

    /**
     * 复杂配置
     */
    @RequestMapping("/showInfo2")
    @HystrixCommand(
            fallbackMethod = "getDefaultInfo",
            commandProperties={
                    // 降级处理超时时间设置
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
                    // 任意时间点允许的最高并发数。超过该设置值后，拒绝执行请求。
                    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "1000"),
            },
            // 配置执行的线城池
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "-1"),
            },
            // 该异常不执行熔断，去执行该异常抛出的自己逻辑
            ignoreExceptions = {ServiceException.class}
    )
    public String showInfo2 (){
        String value = "" ;
        // 测试配置异常不熔断
        // 响应：{"code":500,"msg":"运行异常"}
        if (value.equals("")){
            throw new ServiceException("运行异常") ;
        }
        // 该异常被熔断
        // if (value.equals("")){
        //     throw new RuntimeException("抛出错误") ;
        // }
        return restTemplate.getForObject(server_name+"/getInfo",String.class) ;
    }

    /**
     * 服务熔断调用方法
     */
    public String getDefaultInfo (){
        return "服务被熔断" ;
    }
}
