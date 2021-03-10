package com.java.wxg.bean.vo;

import com.java.wxg.bean.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-14:58
 * @Since:jdk1.8
 * @Description:商品购买联合查询类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoVO {
    private Integer orderDetailsId;//订单详情id
    private Integer orderId;//订单id
    private Integer productId;//商品id
    private String productName;//商品名字
    private Integer productNum;//商品数量
    private Double money;//商品单价
    private Integer vipId;//会员号
    private Double price;//订单总金额
    private Date orderDate;//订单产生时间
    private Integer payType;//订单支付方式 1.现金 2.卡内余额
}