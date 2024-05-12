package top.newhand.shoporder.service.impl;

import org.springframework.stereotype.Service;
import top.newhand.shopcommon.entity.Order;
import top.newhand.shoporder.dao.OrderDao;
import top.newhand.shoporder.service.OrderService;

import javax.annotation.Resource;

/**
 * @author hexg8236
 * @className OrderServiceImpl
 * @Since 2024/5/12 20:47
 * @description 订单接口实现类
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }
}
