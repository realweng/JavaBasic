package com.java.service.impl;

import com.java.dao.ProductDao;
import com.java.dao.impl.ProductDaoImpl;
import com.java.entity.Product;
import com.java.service.ProductService;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-15:07
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();
    /**
     * 查询商品信息
     * @return
     */
    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }

    /**
     * 根据商品ID查询商品信息
     * @param productId 商品ID
     * @return
     */
    @Override
    public Product findProdcutById(Integer productId) {
        return productDao.findProdcutById(productId);
    }

    /**
     * 添加商品
     * @param product 商品对象
     * @return
     */
    @Override
    public int saveProduct(Product product) {
        return productDao.saveProduct(product);
    }

    /**
     * 修改商品
     * @param product
     * @return
     */
    @Override
    public int updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    /**
     * 删除商品
     * @param productId 商品ID
     * @return
     */
    @Override
    public int deleteProduct(Integer productId) {
        return productDao.deleteProduct(productId);
    }
}