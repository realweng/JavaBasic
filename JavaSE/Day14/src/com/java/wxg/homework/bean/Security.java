package com.java.wxg.homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-19:59
 * @Since:jdk1.8
 * @Description:学生信息安全的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Security {
    private boolean isBase;//加密方式 true:Base64 false:MD5
    private boolean isShow;//是否展示个人私密信息
    private String secStuNum; //存储加密的学号
    private String secId;//存储加密的身份证号码
    private String time;//注册时间
}