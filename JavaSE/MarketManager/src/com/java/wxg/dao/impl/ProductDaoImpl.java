package com.java.wxg.dao.impl;

import com.java.wxg.bean.Product;
import com.java.wxg.dao.ProductDao;
import com.java.wxg.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-20:29
 * @Since:jdk1.8
 * @Description:商品数据层实现类
 */
public class ProductDaoImpl implements ProductDao {
    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    @Override
    public int addProduct(Product product) {
        int i = 0;
        String sql = "INSERT INTO product VALUES (null,?,?,?,?,?,?)";
        i = JDBCUtil.update(sql,product.getPname(),product.getPrice(),product.getNum(),product.getDiscount(),product.getTypeId(),product.getState());
        return i;
    }

    /**
     * 更新商品
     *
     * @param product
     * @return
     */
    @Override
    public int updateProduct(Product product) {
        int i = 0;
        String sql = "update product set pname = ?,price = ?,num = ?,discount = ?,typeId = ?,state = ? where id = ?";
        i = JDBCUtil.update(sql,product.getPname(),product.getPrice(),product.getNum(),product.getDiscount(),product.getTypeId(),product.getState(),product.getId());
        return i;
    }

    /**
     * 查询所有产品信息
     *
     * @return
     */
    @Override
    public List<Product> queryProduct() {
        List<Product> list = new ArrayList<>(10);
        String sql = "select * from product";
        list = JDBCUtil.query(sql,Product.class);
        return list;
    }

    /**
     * 通过id删除对应的商品
     *
     * @param id
     * @return
     */
    @Override
    public int deleteProduct(Integer id) {
        int i = 0;
        String sql = "delete from product where id = ?";
        i = JDBCUtil.update(sql,id);
        return i;
    }

    /**
     * 通过id找商品
     * @param id
     * @return
     */
    @Override
    public Product findProductById(Integer id) {
        String sql = "select * from product where id = ?";
        return JDBCUtil.getResultById(sql,Product.class,id);
    }

    /**
     * 查询数据库总条数
     *
     * @return
     */
    @Override
    public List<Product> countRows() {
        String sql = "select count(*) as 'countRows' from product";
        return JDBCUtil.query(sql,Product.class);
    }

    /**
     * 分页
     * @param arg1
     * @param arg2
     * @return
     */
    @Override
    public List<Product> limitPage(int arg1, int arg2) {
        String sql = "select * from product limit ?,?";
        return JDBCUtil.query(sql,Product.class,arg1,arg2);
    }
}