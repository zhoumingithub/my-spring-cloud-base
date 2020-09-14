package cloud.seata.order.controller;

import cloud.seata.order.service.OrderService;
import com.seata.feign.OrderFeign;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController implements OrderFeign {

    @Resource
    private OrderService orderService ;

    @Override
    public Integer createOrder(String orderNo) {
        return orderService.createOrder(orderNo);
    }
}
