package com.java.wxg.dao.impl;

import com.java.wxg.bean.OrderDetails;
import com.java.wxg.bean.OrderInfo;
import com.java.wxg.bean.VIP;
import com.java.wxg.dao.PurchaseManagerDao;
import com.java.wxg.util.JDBCUtil;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-14:47
 * @Since:jdk1.8
 * @Description:购买管理数据层接口实现类
 */
public class PurchaseManagerDaoImpl implements PurchaseManagerDao {

    /**
     * 更新购买订单信息
     *
     * @param map              key:商品id value:对应商品被购买的数量
     * @param orderInfo        订单信息
     * @param orderDetailsList 订单详细信息
     * @param vip              会员信息
     * @return
     */
    @Override
    public void updateOrder(Map<Integer, Integer> map, OrderInfo orderInfo, List<OrderDetails> orderDetailsList, VIP vip) {
        Connection con = JDBCUtil.getConnection();//获得连接
        String sql1 = "update product set num = num - ? where id = ?";
        String sql2 = "update vip set money = ?,jiFen = ?,updateTime = ? where id = ?";
        String sql3 = "insert into orderinfo values(null,?,?,?,?)";
        String sql4 = "insert into orderdetails values(null,?,?,?,?)";
        if (con != null) {
            try {
                con.setAutoCommit(false);//关闭自动提交
                //商品库存更改
                map.forEach((id, num) -> {
                    JDBCUtil.update(con, sql1, num, id);
                });
                //会员余额更改
                if (vip.getId() != 1) {
                    JDBCUtil.update(con,sql2,vip.getMoney(),vip.getJiFen(),vip.getUpdateTime(),vip.getId());
                }else {//不是会员就只更新修改时间
                    JDBCUtil.update(con,sql2,null,null,vip.getUpdateTime(),vip.getId());
                }
                //产生订单信息
                JDBCUtil.update(con,sql3,orderInfo.getVipId(),orderInfo.getPrice(),orderInfo.getOrderDate(),orderInfo.getPayType());
                //产生详单信息,从传过来的list拿数据
                orderDetailsList.forEach(orderDetails -> {
                    JDBCUtil.update(con,sql4,orderDetails.getOrderId(),orderDetails.getProductId(),orderDetails.getNum(),orderDetails.getMoney());
                });
                con.commit();//提交事务
                System.out.println("交易成功！");
            } catch (SQLException e) {
                try {
                    System.out.println("交易失败！");
                    con.rollback();//数据回滚
                    con.setAutoCommit(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                e.printStackTrace();
            }finally {
                //关闭连接
                DbUtils.closeQuietly(con);
            }
        }
    }

    /**
     * 获取上一条订单的id，以便填充到当前详单中的订单id
     *
     * @return
     */
    @Override
    public List<OrderInfo> findLastOrderInfo() {
        String sql = "select * from orderinfo order by id desc limit 1";
        List<OrderInfo> list = JDBCUtil.query(sql, OrderInfo.class);
        return list;
    }
}