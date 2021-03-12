package com.java.wxg.dao.impl;

import com.java.wxg.bean.ProductType;
import com.java.wxg.bean.vo.RankVO;
import com.java.wxg.dao.RankStatisticsDao;
import com.java.wxg.util.JDBCUtil;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-23:33
 * @Since:jdk1.8
 * @Description:排行统计接口的实现类
 */
public class RankStatisticsDaoImpl implements RankStatisticsDao {
    /**
     * 根据月份进行销量排行
     *
     * @param month
     * @return
     */
    @Override
    public List<RankVO> rankByMonth(Integer month) {
        String sql = "select od.id,month(oi.orderDate) as 'month',p.pname,sum(DISTINCT od.num) as 'count',pt.typeName,oi.orderDate from orderinfo oi,orderdetails od,product p,vip v,producttype pt \n" +
                "where oi.id = od.orderId and od.productId = p.id and pt.id = p.typeId and month(oi.orderDate) = ?\n" +
                "GROUP BY p.id ORDER BY sum(DISTINCT od.num) desc limit 0,10";
        return JDBCUtil.query(sql,RankVO.class,month);
    }

    /**
     * 根据商品种类进行排行
     *
     * @param productTypeId 商品种类的id
     * @return
     */
    @Override
    public List<RankVO> rankByProductType(Integer productTypeId) {
        String sql = "select od.id,month(oi.orderDate) as 'month',p.pname,sum(DISTINCT od.num) as 'count',pt.typeName,oi.orderDate from orderinfo oi,orderdetails od,product p,vip v,producttype pt \n" +
                "where oi.id = od.orderId and od.productId = p.id and pt.id = p.typeId and pt.id = ?\n" +
                "GROUP BY p.id ORDER BY sum(DISTINCT od.num) desc limit 0,10";
        return JDBCUtil.query(sql,RankVO.class,productTypeId);
    }

    /**
     * 查询订单表中存在商品的商品种类
     *
     * @return
     */
    @Override
    public List<ProductType> findTypeInOrder() {
        String sql = "select pt.id,pt.typeName from orderinfo oi,orderdetails od,product p,vip v,producttype pt \n" +
                "where oi.id = od.orderId and od.productId = p.id and pt.id = p.typeId\n" +
                "GROUP BY pt.id";
        return JDBCUtil.query(sql,ProductType.class);
    }
}