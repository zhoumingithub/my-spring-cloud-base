package cloud.node09.resource.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("node09-nacos-9001")
public interface MsgFeign {

    @GetMapping("/web/getMsg")
    String getMsg (@RequestParam(name = "name") String name);

    @GetMapping("/web/getJdbc")
    String getJdbc () ;
}