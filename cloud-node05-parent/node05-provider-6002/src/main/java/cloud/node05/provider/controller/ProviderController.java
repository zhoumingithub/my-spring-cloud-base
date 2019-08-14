package cloud.node05.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    private static final Logger LOG = LoggerFactory.getLogger(ProviderController.class) ;

    @RequestMapping(value = "/getAuthorInfo/{authorId}",method = RequestMethod.GET)
    public String getAuthorInfo (@PathVariable("authorId") String authorId) {
        LOG.info("provider-6002");
        return "知了一笑"+authorId ;
    }
}
