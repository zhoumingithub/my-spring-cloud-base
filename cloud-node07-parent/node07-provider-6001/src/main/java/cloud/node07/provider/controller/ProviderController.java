package cloud.node07.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProviderController {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderController.class) ;

    @RequestMapping(value = "/getAuthorInfo/{authorId}",method = RequestMethod.GET)
    public String getAuthorInfo (@PathVariable("authorId") String authorId) {
        LOG.info("provider-6001");
        return "知了一笑"+authorId ;
    }


    @Autowired
    private RestTemplate restTemplate ;

    @RequestMapping("/get6001Info")
    public String get6001Info (){
        String server_name = "http://node07-provider-6002" ;
        return restTemplate.getForObject(server_name+"/get6002Info",String.class) ;
    }
}
