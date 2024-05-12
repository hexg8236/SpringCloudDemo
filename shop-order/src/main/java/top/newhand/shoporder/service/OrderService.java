package top.newhand.shoporder.service;

import top.newhand.shopcommon.entity.Order;

/**
 * @author HeXianGang
 * @className OrderService
 * @description 订单接口类
 * @since 2024/5/12 20:46
 **/

public interface OrderService {

    /**
     * 保存订单
     *
     * @param order
     */
    void save(Order order);

}
