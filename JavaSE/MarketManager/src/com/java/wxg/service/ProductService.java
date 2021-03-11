package com.java.wxg.service;

import com.java.wxg.bean.Product;
import com.java.wxg.dao.ProductDao;
import com.java.wxg.dao.impl.ProductDaoImpl;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-20:30
 * @Since:jdk1.8
 * @Description:商品业务处理层
 */
public class ProductService {
    ProductDao productDao = new ProductDaoImpl();
    /**
     * 添加商品
     * @param product
     * @return
     */
    public int addProduct(Product product){
        return productDao.addProduct(product);
    }

    /**
     * 更新商品
     * @param product
     * @return
     */
    public int updateProduct(Product product){
        return productDao.updateProduct(product);
    }

    /**
     * 查询所有产品信息
     * @return
     */
    public List<Product> queryProduct(){
        return productDao.queryProduct();
    }

    /**
     * 通过id删除对应的商品
     * @return
     */
    public int deleteProduct(Integer id){
        return productDao.deleteProduct(id);
    }

    /**
     * 通过id找商品
     * @param id
     * @return
     */
    public Product findProductById(Integer id){
        return productDao.findProductById(id);
    }

    /**
     * 查询数据库总条数
     * @return
     */
    public List<Product> countRows(){
        return productDao.countRows();
    }

    /**
     * 分页
     * @param arg1
     * @param arg2
     * @return
     */
    public List<Product> limitPage(int arg1,int arg2){
        return productDao.limitPage(arg1,arg2);
    }
}