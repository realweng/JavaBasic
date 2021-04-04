package com.java.service;

import com.java.dao.ProductDao;
import com.java.dao.impl.ProductDaoImpl;
import com.java.entity.Product;
import com.java.service.ProductService;
import com.java.util.ConvertUtils;
import com.java.util.PageInfo;
import com.java.vo.ProductTypeEntity;

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
    public List<ProductTypeEntity> findAllProduct(Product product) {
        return productDao.findAllProduct(product);
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

    /**
     * 分页查询
     * @param product
     * @param nowPageStr
     * @param pageNumStr
     * @return
     */
    @Override
    public PageInfo<ProductTypeEntity> findAllProductByPage(Product product, String nowPageStr, String pageNumStr) {
        //  通过查询条件统计总数量
        Integer count = productDao.countProductNum(product);
        Integer nowPage = nowPageStr == null || "".equals(nowPageStr) ? 1 : Integer.valueOf(nowPageStr);
        Integer pageNum = pageNumStr == null || "".equals(pageNumStr) ? 6 : Integer.valueOf(pageNumStr);

        //  将分页数据存储到PageInfo
        PageInfo pageInfo = new PageInfo(nowPage, pageNum, count);

        // 查询所有的商品信息
        List<ProductTypeEntity> productList = productDao.findAllProductByPage(product, pageInfo);
        pageInfo.setData(productList);
        return pageInfo;
    }

    /**
     * 查询商品数目的条数
     * @param product
     * @return
     */
    @Override
    public Integer countProductNum(Product product) {
        return productDao.countProductNum(product);
    }
}