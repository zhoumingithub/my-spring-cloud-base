package cloud.seata.order.service;

import com.seata.feign.InventoryFeign;
import cloud.seata.order.mapper.OrderMapper;
import com.seata.feign.AccountFeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    private final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private OrderMapper orderMapper ;
    @Resource
    private AccountFeign accountFeign ;
    @Resource
    private InventoryFeign inventoryFeign ;

    @GlobalTransactional
    @Override
    public Integer createOrder(String orderNo) {
        LOGGER.info("Order 生成中 "+orderNo);
        // 本服务下订单库
        Integer insertFlag = orderMapper.insert(orderNo) ;
        // 基于feign接口处理账户和库存
        accountFeign.updateAccount(10L) ;
        inventoryFeign.updateInventory(10) ;
        return insertFlag ;
    }
}
