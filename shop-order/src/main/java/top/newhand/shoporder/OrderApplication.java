package top.newhand.shoporder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author hexg8236
 * @className OrderApplication
 * @Since 2024/5/12 20:41
 * @description 启动类
 *
 * @EnableFeignClients 开启Feign
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EntityScan("top.newhand.shopcommon.entity")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 注入RestTemplate
     *  @LoadBalanced 开启负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
