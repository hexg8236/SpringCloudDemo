package top.newhand.shoporder.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexg8236
 * @className OrderTestContrller
 * @Since 2024/5/13 21:44
 * @description
 **/

@RestController
@Slf4j
public class OrderTestController {

    @RequestMapping("/order/message1")
    public String message1() {
        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2() {
        return "message2";
    }


    @RequestMapping("/order/message3")
    @SentinelResource(value = "message3", blockHandler = "blockHandler", fallback = "fallback")
    public String message3(String name, Integer age) {
        return name + age;
    }

    public String blockHandler(BlockException ex) {
        log.error("{}", ex);
        return "接口被限流了！";
    }

    public String fallback(Throwable throwable) {
        log.error("{}", throwable);
        return "服务降级了！";
    }



}
