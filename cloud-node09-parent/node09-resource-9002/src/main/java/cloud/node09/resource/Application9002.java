package cloud.node09.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"cloud.node09.resource.feign"})
public class Application9002 {
    public static void main(String[] args) {
        SpringApplication.run(Application9002.class,args) ;
    }
}
