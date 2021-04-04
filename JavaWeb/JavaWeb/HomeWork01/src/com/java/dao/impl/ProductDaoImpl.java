package com.java.dao.impl;

import com.java.dao.ProductDao;
import com.java.entity.Product;
import com.java.util.JDBCUtil;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-19:45
 * @Since:jdk1.8
 * @Description:商品数据层接口实现类
 */
public class ProductDaoImpl implements ProductDao {
    /**
     * 查询所有的商品
     * @return
     */
    @Override
    public List<Product> ListProduct() {
        String sql = "select * from product order by id desc";
        return JDBCUtil.query(sql,Product.class);
    }

    @Override
    public Product getProductById(Integer id) {
        String sql = "select * from product where id = ?";
        return JDBCUtil.getResultById(sql,Product.class,id);
    }
}