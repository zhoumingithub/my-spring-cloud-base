package cloud.nacos.client.web;

import cloud.nacos.client.feign.MsgFeign;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ClientWeb {

    @Resource
    private RestTemplate restTemplate ;

    @RequestMapping(value = "/web/getMsgV1/{name}",method = RequestMethod.GET)
    public String getMsgV1 (@PathVariable String name){
        String reqUrl = "http://node08-nacos-server:8001/web/getMsg/"+name ;
        return restTemplate.getForObject(reqUrl,String.class) ;
    }

    @Resource
    private MsgFeign msgFeign ;

    @RequestMapping(value = "/web/getMsgV2/{name}",method = RequestMethod.GET)
    public String getMsgV2 (@PathVariable String name){
        return msgFeign.getMsg(name) ;
    }
}
