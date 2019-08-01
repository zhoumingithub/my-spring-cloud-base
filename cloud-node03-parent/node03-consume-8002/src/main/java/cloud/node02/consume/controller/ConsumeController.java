package cloud.node02.consume.controller;

import cloud.block.code.service.GetAuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class ConsumeController {

    @Resource
    private GetAuthorService getAuthorService ;

    @RequestMapping(value = "/getAuthorInfo")
    public String getAuthorInfo () {
        return getAuthorService.getAuthorInfo("1") ;
    }

    /**
     * 测试服务熔断
     */
    @RequestMapping(value = "/getAuthorInfo1")
    public String getAuthorInfo1 () {
        return getAuthorService.getAuthorInfo("1") ;
    }

}
