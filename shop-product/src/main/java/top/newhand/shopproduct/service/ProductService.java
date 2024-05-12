package top.newhand.shopproduct.service;

import top.newhand.shopcommon.entity.Product;

/**
 * @author HeXianGang
 * @className ProductService
 * @description 产品接口
 * @since 2024/5/12 20:08
 **/

public interface ProductService {

    /**
     * 根据id查询产品
     *
     * @param pid
     * @return
     */
    Product findById(Integer pid);
}
