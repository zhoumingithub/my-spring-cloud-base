package cloud.seata.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    Integer updateAccount (@Param("money") Long money) ;

}
