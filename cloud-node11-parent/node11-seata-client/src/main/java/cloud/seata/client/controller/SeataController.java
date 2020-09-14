package cloud.seata.client.controller;

import com.seata.feign.OrderFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SeataController {

    @Resource
    private OrderFeign orderFeign ;

    @GetMapping("/orderTest")
    public String orderTest (){
        Integer result = orderFeign.createOrder("NO20200909") ;
        return "result="+result ;
    }
}
