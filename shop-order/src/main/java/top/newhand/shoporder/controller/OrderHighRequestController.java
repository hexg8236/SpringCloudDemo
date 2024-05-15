package top.newhand.shoporder.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.newhand.shopcommon.entity.Order;
import top.newhand.shopcommon.entity.Product;
import top.newhand.shoporder.feign.ProductService;
import top.newhand.shoporder.service.OrderService;

import javax.annotation.Resource;

/**
 * @author hexg8236
 * @className OrderHighRequestController
 * @Since 2024/5/13 21:26
 * @description 高并发场景测试
 **/

@RestController
@Slf4j
public class OrderHighRequestController {

    @Resource
    private OrderService orderService;

    @Resource
    private ProductService productService;

    // 准备买1件商品
    @GetMapping("/order/prod/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {
        log.info("接收到{}号商品的下单请求，接下来调用商品微服务查询此商品信息", pid);

        // 通过Feign调用商品微服务
        Product product = productService.findByPid(pid);
        log.info("查询到{}号的商品信息,查询结果为：{}" ,pid, JSON.toJSONString(product));

        //模拟一次网络延时
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Order order = new Order();
        order.setUid(1L);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setProductName(product.getProductName());
        order.setProductPrice(product.getProductPrice());
        order.setNumber(1);
        // 模拟请求，不做保存
        // orderService.save(order);

        log.info("创建订单成功，订单信息为{}", JSON.toJSONString(order));
        return order;
    }

    @GetMapping("/order/message")
    public String message() {
        return "Hello, this is a high request controller.";
    }
}
