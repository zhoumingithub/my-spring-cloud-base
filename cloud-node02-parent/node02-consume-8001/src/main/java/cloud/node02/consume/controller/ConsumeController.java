package cloud.node02.consume.controller;

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

}
