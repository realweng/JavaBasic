package com.java.test;

import com.java.bean.BankUser;
import com.java.dao.BankUserDao;
import com.java.dao.impl.BankUserDaoImpl;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-11:00
 * @Since:jdk1.8
 * @Description:TODO
 */
public class BankUserTest {
    public static void main(String[] args) {
        BankUserDao bankUserDao = new BankUserDaoImpl();
        //转账
//        bankUserDao.transfer(1001,1002,3000);
        //添加
//        bankUserDao.addUser(new BankUser("lili","123456","ggg@qq.com",2000l));
//        System.out.println("总用户数："+bankUserDao.countBankUser());

    }
}