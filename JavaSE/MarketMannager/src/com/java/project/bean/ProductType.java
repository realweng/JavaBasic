package com.java.project.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-20:26
 * @Since:jdk1.8
 * @Description:商品类型实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    private Integer id;//商品类型id
    private Integer parentId;//父级id
    private String typeName;//商品种类名
    private Integer flagParent;//是否为父级id 1为是0为否
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
}