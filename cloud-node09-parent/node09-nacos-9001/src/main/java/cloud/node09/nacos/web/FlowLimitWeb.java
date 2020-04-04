package cloud.node09.nacos.web;

import cloud.node09.nacos.config.FlowRuleConfig;
import cloud.node09.nacos.service.FlowService;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class FlowLimitWeb {

    @Resource
    private FlowService flowService ;

    /**
     * 硬编码
     */
    @RequestMapping(value = "/web/getOrder",method = RequestMethod.GET)
    public String getOrder (@RequestParam("id") Integer id){
        FlowRuleConfig.initFlowQpsRule("getOrder");
        Entry entry = null;
        try {
            // 定义资源，埋点
            entry = SphU.entry("getOrder");
            // 保护的业务逻辑
            return "Order=" + id ;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (entry != null){entry.exit();}
        }
        return "Order Error" ;
    }

    /**
     * 编码简化
     */
    @RequestMapping(value = "/web/getState",method = RequestMethod.GET)
    public String getState (@RequestParam("id") Integer id){
        Entry entry = null;
        try {
            entry = SphU.entry("getOrder",EntryType.IN,2);
            return "state=" + id;
        }
        catch (BlockException e){
            e.printStackTrace();
        } finally {
            if (entry != null){entry.exit();}
        }
        return "State Error" ;
    }

    /**
     * 服务实现上注解
     */
    @RequestMapping(value = "/web/getId",method = RequestMethod.GET)
    public String getId (@RequestParam("id") Integer id){
        return flowService.getId(id) ;
    }

}
