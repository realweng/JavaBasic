package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/30-20:36
 * @Since:jdk1.8
 * @Description:商品类型实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductType {
    private Integer typeId;
    private String typeName;
}