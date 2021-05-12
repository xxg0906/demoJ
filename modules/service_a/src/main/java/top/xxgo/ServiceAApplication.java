package top.xxgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xxg
 */
@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan({"top.xxgo.common","top.xxgo.service_a"})
public class ServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }

}
