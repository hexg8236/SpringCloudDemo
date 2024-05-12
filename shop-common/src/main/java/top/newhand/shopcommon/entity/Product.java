package top.newhand.shopcommon.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hexg8236
 * @className Product
 * @Since 2024/5/12 19:42
 * @description 商品实体类
 **/

@Entity(name = "shop_product")
@Data
public class Product {
    // 商品id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    // 商品名称
    private String productName;
    // 商品价格
    private Double productPrice;
    // 商品库存
    private Integer productStock;
}
