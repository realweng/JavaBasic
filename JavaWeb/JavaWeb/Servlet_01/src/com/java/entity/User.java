package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.DataOutputStream;
import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/25-20:08
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;//唯一编码
    private String userName;//用户名
    private String pwd;//密码
    private String sex;//性别
    private String aihaos;//爱好
    private String address;//地址
    private String myFile;//文件名
    private Date registerDate;//注册时间
}