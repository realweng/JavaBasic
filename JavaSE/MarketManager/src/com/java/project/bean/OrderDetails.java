package com.java.project.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-21:01
 * @Since:jdk1.8
 * @Description:订单详情实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    private Integer id;//订单详情id
    private Integer orderId;//订单id
    private Integer productId;//商品id
    private Integer num;//购买商品数量
    //private Double money;//购买商品的金额
}