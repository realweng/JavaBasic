package com.java.dao.impl;

import com.java.dao.ProductTypeDao;
import com.java.entity.Product;
import com.java.entity.ProductType;
import com.java.util.JDBCUtil;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/31-15:04
 * @Since:jdk1.8
 * @Description:商品类型数据层实现类
 */
public class ProductTypeDaoImpl implements ProductTypeDao {
    /**
     * 查找所有商品类型
     * @return
     */
    @Override
    public List<ProductType> findAllProductType() {
        String sql = "select * from producttype";
        return JDBCUtil.query(sql,ProductType.class);
    }
}