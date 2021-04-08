package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:00
 * @Since:jdk1.8
 * @Description:管理员实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer customerId; //管理员编号
    private String customerName;//登录名
    private String pwd; //登录密码
}