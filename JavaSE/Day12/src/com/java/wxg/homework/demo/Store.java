package com.java.wxg.homework.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-19:14
 * @Since:jdk1.8
 * @Description:作业2 商店类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Store {
    private String id; //多种商品的id
    private int num;   //对应商品的库存
}