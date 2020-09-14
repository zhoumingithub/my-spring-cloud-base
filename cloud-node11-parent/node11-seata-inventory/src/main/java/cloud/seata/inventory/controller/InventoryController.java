package cloud.seata.inventory.controller;

import com.seata.feign.InventoryFeign;
import cloud.seata.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InventoryController implements InventoryFeign {

    @Resource
    private InventoryService inventoryService ;

    @Override
    public Integer updateInventory(Integer inventory) {
        return inventoryService.updateInventory(inventory) ;
    }

}
