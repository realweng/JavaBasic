package com.java.project.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-20:26
 * @Since:jdk1.8
 * @Description:商品实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;//商品id
    private String pname;//商品名
    private Double price;//商品价格
    private Integer num;//商品数量
    private Integer discount;//商品折扣
    private Integer typeId;//商品种类id
    private Integer state;//商品状态 1.上架 2.下架 3.删除
}