package cloud.nacos.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"cloud.nacos.client.feign"})
public class ApplicationClient {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient.class,args) ;
    }
}
