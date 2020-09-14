package cloud.seata.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    Integer insert (@Param("orderNo") String orderNo);
}
