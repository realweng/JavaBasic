package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-15:49
 * @Since:jdk1.8
 * @Description:TODO
 */

/**
 * 银行账户类
 */
public class BankUser {
    public String userNo ; //银行卡号
    public String pwd; //密码
    public float money; //余额

    public BankUser(String userNo, String pwd, float money) {
        //有参构造
        this.userNo = userNo;
        this.pwd = pwd;
        this.money = money;
    }

    public BankUser() {
        //无参构造
    }
}
