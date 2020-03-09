package cloud.nacos.server.web;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
public class JdbcWeb {

    @Resource
    private JdbcTemplate jdbcTemplate ;

    @RequestMapping("/getJdbc")
    public List<String> getJdbc (){
        String sql = "select phone from d_phone" ;
        List<String> phoneEntityList = jdbcTemplate.queryForList(sql,String.class) ;
        return phoneEntityList ;
    }
}
