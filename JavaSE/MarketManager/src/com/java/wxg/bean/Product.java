package com.java.wxg.bean;

import com.java.wxg.constants.MarketConstants;
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
    private String typeName;

    private Integer countRows;//总条数

    @Override
    public String toString() {
        String productState = new String();
        if(state == 1){
            productState = MarketConstants.STATE_ONE;
        }else if(state == 2){
            productState = MarketConstants.STATE_TWO;
        }else {
            productState = MarketConstants.STATE_THREE;
        }
        return  "商品id：" + id +
                ", 商品名：'" + pname + '\'' +
                ", 商品价格：" + price +
                ", 商品数量：" + num +
                ", 商品折扣：" + discount +
                ", 商品类型：" + typeName +
                ", 商品状态：" + productState;
    }
}