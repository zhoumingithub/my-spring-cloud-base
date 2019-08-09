package cloud.node04.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine // 开启监控聚合功能
public class Application_7002 {
    public static void main(String[] args) {
        SpringApplication.run(Application_7002.class,args) ;
    }
}
