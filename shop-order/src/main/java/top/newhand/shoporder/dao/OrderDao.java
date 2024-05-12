package top.newhand.shoporder.dao;

import top.newhand.shopcommon.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author hexg8236
 * @className OrderDao
 * @Since 2024/5/12 20:42
 * @description 订单Dao接口
 **/

public interface OrderDao extends JpaRepository<Order, Long>{
}
