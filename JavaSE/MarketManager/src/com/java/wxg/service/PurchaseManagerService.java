package com.java.wxg.service;

import com.java.wxg.bean.OrderDetails;
import com.java.wxg.bean.OrderInfo;
import com.java.wxg.bean.VIP;
import com.java.wxg.dao.PurchaseManagerDao;
import com.java.wxg.dao.impl.PurchaseManagerDaoImpl;

import java.util.List;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-14:48
 * @Since:jdk1.8
 * @Description:购买管理业务处理层
 */
public class PurchaseManagerService {
    PurchaseManagerDao purchaseManagerDao = new PurchaseManagerDaoImpl();

    /**
     * 执行订单
     *
     * @param map
     * @param orderInfo
     * @param orderDetailsList
     * @param vip
     * @return
     */
    public void updateOrder(Map<Integer, Integer> map, OrderInfo orderInfo, List<OrderDetails> orderDetailsList, VIP vip) {
        purchaseManagerDao.updateOrder(map, orderInfo, orderDetailsList, vip);
    }

    /**
     * 获取上一条订单的id，以便填充当前详单中的订单id
     *
     * @return
     */
    public List<OrderInfo> findLastOrderInfo() {
        return purchaseManagerDao.findLastOrderInfo();
    }
}