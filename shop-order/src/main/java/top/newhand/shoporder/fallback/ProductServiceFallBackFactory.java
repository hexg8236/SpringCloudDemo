package top.newhand.shoporder.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import top.newhand.shopcommon.entity.Product;
import top.newhand.shoporder.feign.ProductService;

/**
 * @author hexg8236
 * @className ProductServiceFallBackFactory
 * @Since 2024/5/15 22:40
 * @description Feign容错接口实体类
 **/
@Component
public class ProductServiceFallBackFactory implements FallbackFactory<ProductService> {

    @Override
    public ProductService create(Throwable throwable) {
        return new ProductService() {
            @Override
            public Product findByPid(Integer pid) {
                throwable.printStackTrace();
                Product product = new Product();
                product.setPid(-1L);
                return product;
            }
        };
    }
}
