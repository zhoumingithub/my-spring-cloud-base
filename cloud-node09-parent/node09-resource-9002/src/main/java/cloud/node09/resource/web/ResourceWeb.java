package cloud.node09.resource.web;

import cloud.node09.resource.feign.MsgFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class ResourceWeb {

    private static Logger LOGGER = LoggerFactory.getLogger(ResourceWeb.class);

    @Resource
    private MsgFeign msgFeign ;

    @RequestMapping(value = "/web/getJdbc",method = RequestMethod.GET)
    public String getJdbc () {
        return msgFeign.getJdbc() ;
    }

}
