package cloud.seata.inventory.service;

import cloud.seata.inventory.mapper.InventoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceImpl.class);

    @Resource
    private InventoryMapper inventoryMapper ;
    @Override
    public Integer updateInventory(Integer inventory) {
        LOGGER.info("Inventory 销库存 "+inventory);
        int i = 1/0 ;
        return inventoryMapper.updateInventory(inventory);
    }
}
