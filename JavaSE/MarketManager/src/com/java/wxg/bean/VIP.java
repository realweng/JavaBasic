package com.java.wxg.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-20:27
 * @Since:jdk1.8
 * @Description:会员实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VIP {
    private Integer id;//会员id
    private String cardNumber;//会员卡号
    private String vipPassword;//会员密码
    private String vipName;//会员姓名
    private String iphone;//会员电话
    private Integer jiFen;//会员积分
    private Double money;//剩余金额
    private Date createTime;//办卡时间
    private Date updateTime;//上次操作时间

    @Override
    public String toString() {
        return  "会员编号：" + id +
                ", 会员卡号：" + cardNumber + '\'' +
                ", 会员姓名：" + vipName + '\'' +
                ", 会员电话：" + iphone + '\'' +
                ", 会员积分：" + jiFen +
                ", 会员余额：" + money +
                ", 创建时间：" + createTime +
                ", 更新时间：" + updateTime;
    }
}