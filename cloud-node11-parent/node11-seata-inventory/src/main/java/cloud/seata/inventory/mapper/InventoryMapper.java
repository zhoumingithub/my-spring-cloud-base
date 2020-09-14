package cloud.seata.inventory.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InventoryMapper {

    Integer updateInventory (@Param("inventory") Integer inventory) ;

}
