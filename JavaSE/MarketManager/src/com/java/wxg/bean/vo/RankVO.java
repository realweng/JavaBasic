package com.java.wxg.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/11-10:31
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RankVO {
    private Integer id;//详单id
    private Integer month;//订单月份
    private String pname;//商品名字
    private Integer count;//销售总量
    private String typeName;//商品种类名
    private Date orderDate;//订单日期

    @Override
    public String toString() {
        return "详单编号：" + id +
                ", 订单月份" + month +
                ", 商品名字：" + pname + '\'' +
                ", 销售总量：" + count +
                ", 商品种类：" + typeName + '\'' +
                ", 订单日期：" + orderDate;
    }
}