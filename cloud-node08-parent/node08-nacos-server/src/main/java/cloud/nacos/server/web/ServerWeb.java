package cloud.nacos.server.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServerWeb {
    private static Logger logger = LoggerFactory.getLogger(ServerWeb.class) ;
    @RequestMapping(value = "/web/getMsg",method = RequestMethod.GET)
    public String getMsg (@RequestParam("name") String name){
        logger.info("8001 服务被调用...");
        return "Hello：" + name ;
    }
}
