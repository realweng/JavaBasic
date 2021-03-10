package com.java.wxg.dao;

import com.java.wxg.bean.OrderDetails;
import com.java.wxg.bean.OrderInfo;
import com.java.wxg.bean.VIP;

import java.util.List;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-14:47
 * @Since:jdk1.8
 * @Description:购买管理数据层接口
 */
public interface PurchaseManagerDao {
    /**
     * 更新购买订单信息
     * @param map 商品id及对应商品被购买的数量
     * @param orderInfo 订单信息
     * @param orderDetailsList 订单详细信息
     * @param vip 会员信息
     * @return
     */
    public void updateOrder(Map<Integer,Integer> map, OrderInfo orderInfo, List<OrderDetails> orderDetailsList, VIP vip);

    /**
     * 获取上一条订单的id，以便填充当前详单中的订单id
     * @return
     */
    public List<OrderInfo> findLastOrderInfo();
}
