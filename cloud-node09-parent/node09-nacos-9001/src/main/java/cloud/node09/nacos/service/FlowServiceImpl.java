package cloud.node09.nacos.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class FlowServiceImpl implements FlowService {

    @SentinelResource(value = "getId")
    @Override
    public String getId(Integer id) {
        return "ID="+id ;
    }

    @Resource
    private JdbcTemplate jdbcTemplate ;

    @SentinelResource(value = "getPhone",blockHandler = "exceptionHandler", fallback = "fallback")
    @Override
    public String getPhone(Integer id) {
        String sql = "select phone from d_phone WHERE id="+id ;
        Integer.parseInt("hand") ;
        return jdbcTemplate.queryForList(sql,String.class).get(0) ;
    }

    // 降级处理
    public String fallback(Integer id) {
        return "服务降级,id="+id ;
    }

    // 异常处理
    public String exceptionHandler(Integer id,BlockException be) {
        be.printStackTrace();
        return "服务抛异常,id="+id ;
    }
}
