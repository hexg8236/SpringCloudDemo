package top.newhand.shopproduct.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.newhand.shopcommon.entity.Product;
import top.newhand.shopproduct.service.ProductService;

import javax.annotation.Resource;

/**
 * @author hexg8236
 * @className ProductController
 * @Since 2024/5/12 20:12
 * @description 产品Controller
 **/

@RestController
@Slf4j
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid){
        Product product = productService.findById(pid);
        log.info("查询到商品:" + JSON.toJSONString(product));
        return product;
    }

}
