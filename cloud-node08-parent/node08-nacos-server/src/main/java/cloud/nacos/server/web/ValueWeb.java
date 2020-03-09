package cloud.nacos.server.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ValueWeb {

    @Value("${my.name:}")
    private String myName ;

    @Value("${my.info:}")
    private String myInfo ;

    @RequestMapping("/getNameInfo")
    public String getNameInfo (){
        return myName+":"+myInfo ;
    }
}
