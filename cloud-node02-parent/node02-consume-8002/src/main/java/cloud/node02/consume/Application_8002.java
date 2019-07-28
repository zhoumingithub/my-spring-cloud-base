package cloud.node02.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient    // 本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient
// 因为包名路径不同，需要加basePackages属性
@EnableFeignClients(basePackages={"cloud.block.code.service"})
public class Application_8002 {
    public static void main(String[] args) {
        SpringApplication.run(Application_8002.class,args) ;
    }
}