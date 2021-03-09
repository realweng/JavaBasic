package com.java.wxg.service;

import com.java.wxg.bean.ProductType;
import com.java.wxg.dao.ProductTypeDao;
import com.java.wxg.dao.impl.ProductTypeDaoImpl;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-17:01
 * @Since:jdk1.8
 * @Description:商品类型业务处理层
 */
public class ProductTypeService {
    ProductTypeDao productTypeDao = new ProductTypeDaoImpl();

    /**
     * 添加商品类型
     */
    public int addProductType(ProductType productType) {
        return productTypeDao.addProductType(productType);
    }

    /**
     * 查询所有商品类型
     *
     * @return
     */
    public List<ProductType> queryProductType() {
        return productTypeDao.queryProductType();
    }

    /**
     * 通过id删除商品类型
     * @param id
     * @return
     */
    public int deleteProductType(Integer id) {
        return productTypeDao.deleteProductType(id);
    }

    /**
     * 修改商品类型信息
     * @param productType
     * @return
     */
    public int updateProductType(ProductType productType){
        return productTypeDao.updateProductType(productType);
    }

    /**
     * 通过id找商品
     * @param id
     * @return
     */
    public ProductType findProductTypeById(Integer id){
        return productTypeDao.findProductTypeById(id);
    }
}