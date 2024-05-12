package top.newhand.shopproduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.newhand.shopcommon.entity.Product;

/**
 * @author HeXianGang
 * @className ProducatDap
 * @description 产品Dao接口
 * @since 2024/5/12 20:06
 **/

public interface ProductDao extends JpaRepository<Product,Long> {
}
