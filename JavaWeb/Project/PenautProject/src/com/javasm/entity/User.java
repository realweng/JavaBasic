package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-22:43
 * @Since:jdk1.8
 * @Description:普通用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;
    private String userName;
    private String pwd;
    private String headPic;
    private String headPicThumb;
    private String des;
    private Integer sex;
    private Date birthday;
    private String avatarColor;
    private String phone;
    private Integer grade;
}