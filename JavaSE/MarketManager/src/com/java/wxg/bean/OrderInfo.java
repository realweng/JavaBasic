package com.java.wxg.bean;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-20:32
 * @Since:jdk1.8
 * @Description:订单信息实体类
 */
public class OrderInfo {
    private Integer id;//订单id
    private Integer vipId;//会员号
    private Double price;//订单总金额
    private Date orderDate;//订单产生时间
    private Integer payType;//订单支付方式 1.现金 2.卡内余额
   // private Double money;
}