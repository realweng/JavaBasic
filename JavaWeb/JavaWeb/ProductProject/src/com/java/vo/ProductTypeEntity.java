package com.java.vo;

import com.java.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/30-20:30
 * @Since:jdk1.8
 * @Description:商品联表查询实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeEntity extends Product {
    private String typeName;
}