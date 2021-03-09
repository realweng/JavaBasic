package com.java.wxg.dao.impl;

import com.java.wxg.bean.ProductType;
import com.java.wxg.dao.ProductTypeDao;
import com.java.wxg.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-17:00
 * @Since:jdk1.8
 * @Description:商品类型数据层实现类
 */
public class ProductTypeDaoImpl implements ProductTypeDao {
    /**
     * 添加商品类型
     *
     * @param productType
     * @return
     */
    @Override
    public int addProductType(ProductType productType) {
        int i = 0;
        String sql = "INSERT INTO producttype VALUES(null,?,?,?,?,null)";
        i = JDBCUtil.update(sql,productType.getParentId(),productType.getTypeName(),productType.getFlagParent(),productType.getCreateTime());
        return i;
    }

    /**
     * 修改商品信息
     *
     * @param productType
     * @return
     */
    @Override
    public int updateProductType(ProductType productType) {
        int i = 0;
        String sql = "update producttype set parentId = ?,typeName = ?,flagParent = ?,updateTime = ? where id = ?";
        i = JDBCUtil.update(sql,productType.getParentId(),productType.getTypeName(),productType.getFlagParent(),productType.getUpdateTime(),productType.getId());
        return i;
    }

    /**
     * 查询所有商品信息
     *
     * @return
     */
    @Override
    public List<ProductType> queryProductType() {
        List<ProductType> list = new ArrayList<>(10);
        String sql = "select * from producttype";
        list = JDBCUtil.query(sql, ProductType.class);
        return list;
    }

    /**
     * 通过id删除商品信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteProductType(Integer id) {
        int i = 0;
        String sql = "delete from producttype where id = ?";
        i = JDBCUtil.update(sql,id);
        return i;
    }

    /**
     * 通过id找商品类型
     *
     * @param id
     * @return
     */
    @Override
    public ProductType findProductTypeById(Integer id) {
        ProductType productType = new ProductType();
        String sql = "select * from producttype where id = ?";
        productType = JDBCUtil.getResultById(sql,ProductType.class,id);
        return productType;
    }
}