package top.newhand.shoporder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.newhand.shopcommon.entity.Product;
import top.newhand.shoporder.fallback.ProductServiceFallBackFactory;

/**
 * @author HeXianGang
 * @className ProductService
 * @description Feign调用
 * @since 2024/5/13 21:21
 *
 * fallback: 指定容错类 --集成Sentinel
 **/

@FeignClient(value = "shop-product",
        // fallback = ProductServiceFallBack.class,  二者只能选其一
        fallbackFactory = ProductServiceFallBackFactory.class)
public interface ProductService {


    /**
     * 根据商品id查询商品
     *
     * @param pid 商品id
     * @return 商品信息
     *
     * 指定调用提供者的哪个方法
     * @FeignClient+@GetMapping 就是一个完整的请求路径 http://serviceproduct/product/{pid}
     */
    @GetMapping("/product/{pid}")
    Product findByPid(@PathVariable Integer pid);
}
