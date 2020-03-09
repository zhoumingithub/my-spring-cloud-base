package cloud.nacos.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("node08-nacos-server")
public interface MsgFeign {

    @GetMapping("/web/getMsg")
    String getMsg (@RequestParam(name = "name") String name);

}
