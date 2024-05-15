package top.newhand.shoporder.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.newhand.shopcommon.entity.Product;
import top.newhand.shoporder.feign.ProductService;

/**
 * @author hexg8236
 * @className ProductServiceFallBack
 * @Since 2024/5/15 22:35
 * @description Feign接口的容错类
 **/

@Component
@Slf4j
public class ProductServiceFallBack implements ProductService {

    @Override
    public Product findByPid(Integer pid) {

        // 容错类 创建一个Product
        Product product = new Product();
        product.setPid(-1L);
        return product;
    }
}
