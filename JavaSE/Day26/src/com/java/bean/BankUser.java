package com.java.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-10:18
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BankUser {
    private Integer userId;
    private String userName;
    private String userPhone;
    private String userEmail;
    private Long userMoney;

    public BankUser( String userName, String userPhone, String userEmail, Long userMoney) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userMoney = userMoney;
    }

    @Override
    public String toString() {
        return "BankUser{" +
                "用户id=" + userId +
                ", 用户姓名='" + userName + '\'' +
                ", 用户手机='" + userPhone + '\'' +
                ", 电子邮件='" + userEmail + '\'' +
                ", 余额=" + userMoney +
                '}';
    }
}