package cloud.node02.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderController.class) ;

    @HystrixCommand(fallbackMethod = "getDefaultInfo")
    @RequestMapping("/getInfo")
    public String getInfo (){
        LOG.info("provider-6002");
        return "success" ;
    }
    /**
     * 服务熔断调用方法
     */
    public String getDefaultInfo (){
        return "服务被熔断" ;
    }
    @RequestMapping(value = "/getAuthorInfo/{authorId}",method = RequestMethod.GET)
    public String getAuthorInfo (@PathVariable("authorId") String authorId) {
        LOG.info("provider-6002");
        return "知了一笑"+authorId ;
    }
}
