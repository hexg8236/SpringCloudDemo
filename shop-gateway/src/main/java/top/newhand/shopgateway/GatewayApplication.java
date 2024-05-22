package top.newhand.shopgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hexg8236
 * @className GatewayApplication
 * @Since 2024/5/15 22:52
 * @description 启动类
 **/

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"top.newhand"})
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
