package top.newhand.shopproduct.service.impl;

import org.springframework.stereotype.Service;
import top.newhand.shopcommon.entity.Product;
import top.newhand.shopproduct.dao.ProductDao;
import top.newhand.shopproduct.service.ProductService;

import javax.annotation.Resource;

/**
 * @author hexg8236
 * @className ProductServiceImpl
 * @Since 2024/5/12 20:09
 * @description 产品接口实现类
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    /**
     * 根据id查询产品
     * @param pid
     * @return
     */
    @Override
    public Product findById(Integer pid) {
        return productDao.findById(Long.valueOf(pid)).get();
    }
}
