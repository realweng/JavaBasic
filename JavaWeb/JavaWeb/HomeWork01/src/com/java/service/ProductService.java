package com.java.service;

import com.java.entity.Product;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-19:48
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface ProductService {
    /**
     * 商品查询业务层
     * @return
     */
    public List<Product> ListProduct();

    /**
     * 通过id找到商品
     * @param id
     * @return
     */
    public Product getProductById(Integer id);
}