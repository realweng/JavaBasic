package com.java.wxg.bean;

import com.java.wxg.constants.MarketConstants;
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
    private String typeId;//商品种类id
    private Integer flagParent;//是否为父级id 1为是0为否
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String parentName;//父级名称

    @Override
    public String toString() {
        String isParent = new String();
        if(flagParent == 1){
            isParent = MarketConstants.FLAG_PARENT_ONE;
        }else {
            isParent =MarketConstants.FLAG_PARENT_ZERO;
        }
        if(parentName == null){
            parentName = "无父级";
        }
        return  "商品类型编号：" + id +
                ", 父级名称：" + parentName +
                ", 商品类型名：'" + typeName + '\'' +
                ", 父级标记：" + isParent +
                ", 创建时间：" + createTime +
                ", 修改时间：" + updateTime
                ;
    }
}