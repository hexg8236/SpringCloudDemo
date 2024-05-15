package top.newhand.shoporder.controller;

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


}
