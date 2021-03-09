package com.java.wxg.dao;

import com.java.wxg.bean.Product;
import com.java.wxg.bean.ProductType;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-20:29
 * @Since:jdk1.8
 * @Description:商品数据层接口
 */
public interface ProductDao {
    /**
     * 添加商品
     * @param product
     * @return
     */
    public int addProduct(Product product);

    /**
     * 更新商品
     * @param product
     * @return
     */
    public int updateProduct(Product product);

    /**
     * 查询所有产品信息
     * @return
     */
    public List<Product> queryProduct();

    /**
     * 通过id删除对应的商品
     * @return
     */
    public int deleteProduct(Integer id);

    /**
     * 通过id找商品
     * @param id
     * @return
     */
    public Product findProductById(Integer id);
}