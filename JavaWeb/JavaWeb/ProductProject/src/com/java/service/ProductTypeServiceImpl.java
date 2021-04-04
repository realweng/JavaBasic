package com.java.service;

import com.java.dao.ProductTypeDao;
import com.java.dao.impl.ProductTypeDaoImpl;
import com.java.entity.Product;
import com.java.entity.ProductType;
import com.java.service.ProductTypeService;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/31-15:09
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ProductTypeServiceImpl implements ProductTypeService {
    private ProductTypeDao productTypeDao;

    /**
     * 初始化
     */
    public ProductTypeServiceImpl() {
        productTypeDao = new ProductTypeDaoImpl();
    }

    /**
     * 查找所有的商品类型
     *
     * @return
     */
    @Override
    public List<ProductType> findAllProductType() {
        return productTypeDao.findAllProductType();
    }
}