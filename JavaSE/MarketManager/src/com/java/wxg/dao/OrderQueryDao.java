package com.java.wxg.dao;

import com.java.wxg.bean.vo.OrderQueryVO;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-22:00
 * @Since:jdk1.8
 * @Description:订单查询数据层接口
 */
public interface OrderQueryDao {
    /**
     * 通过会员编号查询订单信息
     * @param vipId
     * @return
     */
    public List<OrderQueryVO> queryByVipId(Integer vipId);

    /**
     * 通过商品编号查询订单信息
     * @param productId
     * @return
     */
    public List<OrderQueryVO> queryByProductId(Integer productId);
}