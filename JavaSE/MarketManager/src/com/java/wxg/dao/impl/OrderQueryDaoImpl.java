package com.java.wxg.dao.impl;

import com.java.wxg.bean.vo.OrderQueryVO;
import com.java.wxg.dao.OrderQueryDao;
import com.java.wxg.util.JDBCUtil;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-22:01
 * @Since:jdk1.8
 * @Description:订单查询接口的实现类
 */
public class OrderQueryDaoImpl implements OrderQueryDao {
    /**
     * 通过会员编号查询订单信息
     *
     * @param vipId
     * @return
     */
    @Override
    public List<OrderQueryVO> queryByVipId(Integer vipId) {
        String sql ="select a.vipId,d.vipName,b.productId,c.pname,b.money,b.num,a.price,a.payType,b.id,a.orderDate from orderinfo a,orderdetails b,product c ,vip d\n" +
                "where a.vipId = ? and a.id = b.orderId and c.id = b.productId and a.vipId = d.id";
        return JDBCUtil.query(sql, OrderQueryVO.class,vipId);
    }

    /**
     * 通过商品编号查询订单信息
     *
     * @param productId
     * @return
     */
    @Override
    public List<OrderQueryVO> queryByProductId(Integer productId) {
        String sql = "select a.vipId,d.vipName,b.productId,c.pname,b.money,b.num,a.price,a.payType,b.id,a.orderDate from orderinfo a,orderdetails b,product c ,vip d\n" +
                "where b.productId = ? and a.id = b.orderId and c.id = b.productId and a.vipId = d.id";
        return JDBCUtil.query(sql,OrderQueryVO.class,productId);
    }
}