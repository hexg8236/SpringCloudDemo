package top.newhand.shopproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author hexg8236
 * @className ProductApplication
 * @Since 2024/5/12 19:58
 * @description 启动类
 **/

// 因为shop-common中的实体类在shop-product中使用，所以需要在启动类中添加@EntityScan注解
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("top.newhand.shopcommon.entity")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
