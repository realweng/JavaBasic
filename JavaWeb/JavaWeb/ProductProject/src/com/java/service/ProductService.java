package com.java.service;

import com.java.entity.Product;
import com.java.vo.ProductTypeEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-15:05
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface ProductService {
    /**
     * 查询商品信息
     *
     * @return
     */
    List<ProductTypeEntity> findAllProduct();

    /**
     * 根据商品ID查询商品信息
     *
     * @param productId 商品ID
     * @return
     */
    Product findProdcutById(Integer productId);

    /**
     * 添加商品
     *
     * @param product 商品对象
     * @return
     */
    int saveProduct(Product product);

    /**
     * 修改商品
     *
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 删除商品
     *
     * @param productId 商品ID
     * @return
     */
    int deleteProduct(Integer productId);
}
