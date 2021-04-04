package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.annotation.WebServlet;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-19:26
 * @Since:jdk1.8
 * @Description:订单项
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Integer id;
    private Product product;
    private Integer num;
}