package com.java.service.impl;

import com.java.dao.ProductDao;
import com.java.dao.impl.ProductDaoImpl;
import com.java.entity.Product;
import com.java.service.ProductService;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-19:49
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    /**
     * 商品查询业务层
     *
     * @return
     */
    @Override
    public List<Product> ListProduct() {
        return productDao.ListProduct();
    }

    /**
     * 通过id找到商品
     *
     * @param id
     * @return
     */
    @Override
    public Product getProductById(Integer id) {
        return productDao.getProductById(id);
    }
}