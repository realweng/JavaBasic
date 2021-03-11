package com.java.wxg.service;

import com.java.wxg.bean.vo.OrderQueryVO;
import com.java.wxg.dao.OrderQueryDao;
import com.java.wxg.dao.impl.OrderQueryDaoImpl;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-22:04
 * @Since:jdk1.8
 * @Description:订单查询业务处理层
 */
public class OrderQueryService {
    OrderQueryDao orderQueryDao = new OrderQueryDaoImpl();
    /**
     * 通过会员编号查询订单信息
     *
     * @param vipId
     * @return
     */
    public List<OrderQueryVO> queryByVipId(Integer vipId) {
        return orderQueryDao.queryByVipId(vipId);
    }

    /**
     * 通过商品编号查询订单信息
     *
     * @param productId
     * @return
     */
    public List<OrderQueryVO> queryByProductId(Integer productId) {
        return orderQueryDao.queryByProductId(productId);
    }
}