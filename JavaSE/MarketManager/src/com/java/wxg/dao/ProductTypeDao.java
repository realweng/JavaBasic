package com.java.wxg.dao;

import com.java.wxg.bean.ProductType;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-17:00
 * @Since:jdk1.8
 * @Description:商品类型数据访问层
 */
public interface ProductTypeDao {
    /**
     * 添加商品类型
     * @param productType
     * @return
     */
    public int addProductType(ProductType productType);

    /**
     * 修改商品信息
     * @param productType
     * @return
     */
    public int updateProductType(ProductType productType);

    /**
     * 查询所有商品信息
     * @return
     */
    public List<ProductType> queryProductType();

    /**
     * 通过id删除商品信息
     * @param id
     * @return
     */
    public int deleteProductType(Integer id);

    /**
     * 通过id找商品类型
     * @param id
     * @return
     */
    public ProductType findProductTypeById(Integer id);
}