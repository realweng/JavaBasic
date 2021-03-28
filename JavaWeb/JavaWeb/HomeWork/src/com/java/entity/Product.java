package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-13:47
 * @Since:jdk1.8
 * @Description:产品实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productId;
    private String productName;
    private Float productPrice;
    private Integer stockNumber;
    private Integer typeId;
    private Float discount;

}