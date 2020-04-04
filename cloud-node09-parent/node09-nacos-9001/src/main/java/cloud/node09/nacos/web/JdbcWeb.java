package cloud.node09.nacos.web;

import cloud.node09.nacos.service.FlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class JdbcWeb {

    private static Logger logger = LoggerFactory.getLogger(JdbcWeb.class) ;

    @Resource
    private FlowService flowService ;

    @RequestMapping("/web/getJdbc")
    public String getJdbc (){
        logger.info("9001 服务被调用...");
        Integer id = 1 ;
        return flowService.getPhone(id) ;
    }
}