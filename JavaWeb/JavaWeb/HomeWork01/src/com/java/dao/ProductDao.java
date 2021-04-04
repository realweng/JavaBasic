package com.java.dao;

import com.java.entity.Product;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-19:43
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface ProductDao {
    /**
     * 查询所有的商品
     * @return
     */
    public List<Product> ListProduct();

    public Product getProductById(Integer id);
}
