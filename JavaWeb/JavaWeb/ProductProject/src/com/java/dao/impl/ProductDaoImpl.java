package com.java.dao.impl;

import com.java.dao.ProductDao;
import com.java.entity.Product;
import com.java.entity.ProductType;
import com.java.util.JDBCUtil;
import com.java.util.PageInfo;
import com.java.vo.ProductTypeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-15:03
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ProductDaoImpl implements ProductDao {
    /**
     * 查询商品信息
     *
     * @return
     */
    @Override
    public List<ProductTypeEntity> findAllProduct(Product product) {
        StringBuffer sql = new StringBuffer("select p.*,pt.typeName as 'typeName' FROM product p,producttype pt where p.typeid=pt.typeid");
        if (product != null) {
            if (product.getProductName() != null && !"".equals(product.getProductName())) {//  商品名称
                sql.append(" and productName like '%" + product.getProductName() + "%' ");
            }
            if (product.getTypeId() != null) {
                sql.append(" and p.typeId = " + product.getTypeId());
            }
        }
        return JDBCUtil.query(sql.toString(), ProductTypeEntity.class);
    }

    /**
     * 根据商品ID查询商品信息
     *
     * @param productId 商品ID
     * @return
     */
    @Override
    public Product findProdcutById(Integer productId) {
        String sql = "select * from product where productId = ?";
        return JDBCUtil.getResultById(sql, Product.class, productId);
    }

    /**
     * 分页查询
     *
     * @param product
     * @param pageInfo
     * @return
     */
    @Override
    public List<ProductTypeEntity> findAllProductByPage(Product product, PageInfo pageInfo) {
        StringBuffer sql = new StringBuffer("select p.*,pt.typeName as 'typeName' FROM product p,producttype pt where p.typeid=pt.typeid");
        if (product != null) {
            if (product.getProductName() != null && !"".equals(product.getProductName())) {//  商品名称
                sql.append(" and productName like '%" + product.getProductName() + "%' ");
            }
            if (product.getTypeId() != null) {
                sql.append(" and p.typeId = " + product.getTypeId());
            }
        }
        sql.append(" limit ?,?");
        return JDBCUtil.query(sql.toString(), ProductTypeEntity.class, pageInfo.getStartIndex(), pageInfo.getPageNum());
    }

    /**
     * 查询商品数目
     *
     * @param product
     * @return
     */
    @Override
    public Integer countProductNum(Product product) {
        StringBuffer sql = new StringBuffer("select count(1) FROM product p,producttype pt where p.typeid=pt.typeid");
        if (product != null) {
            if (product.getProductName() != null && !"".equals(product.getProductName())) {//  商品名称
                sql.append(" and productName like '%" + product.getProductName() + "%' ");
            }
            if (product.getTypeId() != null) {
                sql.append(" and p.typeId = " + product.getTypeId());
            }
        }
        return JDBCUtil.count(sql.toString());
    }

    /**
     * 添加商品
     *
     * @param product 商品对象
     * @return
     */
    @Override
    public int saveProduct(Product product) {
        String sql = "insert into product values(null,?,?,?,?,?)";
        return JDBCUtil.update(sql, product.getProductName(), product.getProductPrice(), product.getStockNumber(), product.getTypeId(), product.getDiscount());
    }

    /**
     * 修改商品
     *
     * @param product
     * @return
     */
    @Override
    public int updateProduct(Product product) {
        String sql = "update product set productname=?,productprice=?,stocknumber=?,typeid=?,discount=? where productid=?";
        return JDBCUtil.update(sql, product.getProductName(), product.getProductPrice(), product.getStockNumber(), product.getTypeId(), product.getDiscount(), product.getProductId());
    }

    /**
     * 删除商品
     *
     * @param productId 商品ID
     * @return
     */
    @Override
    public int deleteProduct(Integer productId) {
        String sql = "delete from product where productId = ?";
        return JDBCUtil.update(sql, productId);
    }
}