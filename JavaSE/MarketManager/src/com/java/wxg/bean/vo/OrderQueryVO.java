package com.java.wxg.bean.vo;

import com.java.wxg.bean.Product;
import com.java.wxg.constants.MarketConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-14:58
 * @Since:jdk1.8
 * @Description:订单联合查询类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderQueryVO {
    private Integer vipId;//会员号
    private String vipName;//会员名字
    private Integer productId;//商品id
    private String pname;//商品名字
    private Double money;//商品单价
    private Integer num;//商品数量
    private Double price;//商品总价
    private Integer payType;//订单支付方式 1.现金 2.卡内余额
    private Integer id;//详单id
    private Date orderDate;//订单产生时间

    @Override
    public String toString() {
        String type = new String();
        if (payType == 2) {
            type = MarketConstants.PAY_TYPE_TWO;
        } else {
            type = MarketConstants.PAY_TYPE_ONE;
        }
        return "会员编号：" + vipId +
                ", 会员名称：'" + vipName + '\'' +
                ", 商品编号：" + productId +
                ", 商品名称：" + pname + '\'' +
                ", 商品单价：" + money +
                ", 购买数目：" + num +
                ", 总价格：" + price +
                ", 支付方式：" + type +
                ", 订单编号" + id +
                ", 订单时间：" + orderDate;
    }
}