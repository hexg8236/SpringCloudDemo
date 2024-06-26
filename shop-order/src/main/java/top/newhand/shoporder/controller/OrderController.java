package top.newhand.shoporder.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import top.newhand.shopcommon.entity.Order;
import top.newhand.shopcommon.entity.Product;
import top.newhand.shoporder.feign.ProductService;
import top.newhand.shoporder.service.OrderService;

import javax.annotation.Resource;

/**
 * @author hexg8236
 * @className OrderController
 * @Since 2024/5/12 20:49
 * @description 订单控制器
 **/

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private OrderService orderService;

    @Resource
    private ProductService productService;

    @Resource
    private DiscoveryClient discoveryClient;

    // 准备买1件商品
    // @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info(">>客户下单， 这时候要调用商品微服务查询商品信息");
        // 通过restTemplate调用商品微服务
        // Product product = restTemplate.getForObject("http://localhost:8081/product/" + pid, Product.class);

        // 从nacos中获取微服务地址
        // List<ServiceInstance> instances = discoveryClient.getInstances("shop-product");
        // int index = new Random().nextInt(instances.size());
        // ServiceInstance serviceInstance = (ServiceInstance) instances.get(index);
        // // String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        // // log.info(">>从nacos中获取到的微服务地址为:" + url);
        // String url = "shop-product";

        // 通过Feign调用商品微服务
        Product product = productService.findByPid(pid);
        if (product.getPid() == -1L) {
            Order order = new Order();
            order.setUsername("下单失败");
            return order;
        }
        log.info(">>商品信息,查询结果:" + JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1L);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setProductName(product.getProductName());
        order.setProductPrice(product.getProductPrice());
        order.setNumber(1);
        orderService.save(order);
        return order;
    }
}
