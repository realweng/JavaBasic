package com.java.dao;

import com.java.entity.Product;
import com.java.entity.ProductType;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/31-15:03
 * @Since:jdk1.8
 * @Description:商品类型数据层接口
 */
public interface ProductTypeDao {
    /**
     * 查找所有商品类型
     * @return
     */
    public List<ProductType> findAllProductType();
}
