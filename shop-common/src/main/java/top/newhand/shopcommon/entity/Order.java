package top.newhand.shopcommon.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hexg8236
 * @className Order
 * @Since 2024/5/12 19:43
 * @description 订单实体类
 **/

@Entity(name = "shop_order")
@Data
public class Order {
    // 订单id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    // 用户id
    private Long uid;
    // 商品id
    private Long pid;
    // 用户名
    private String username;
    // 商品名称
    private String productName;
    // 商品价格
    private Double productPrice;
    // 商品数量
    private Integer number;
}
