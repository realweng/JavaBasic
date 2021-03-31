package com.java.service;

import com.java.entity.Product;
import com.java.entity.ProductType;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/31-15:07
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface ProductTypeService {
    public List<ProductType> findAllProductType();
}
