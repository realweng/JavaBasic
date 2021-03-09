package com.java.wxg.demo.test;

import com.java.wxg.demo.bean.BankException;
import com.java.wxg.demo.bean.BankUser;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-15:40
 * @Since:jdk1.8
 * @Description:TODO
 */
public class BankTest {
    static Scanner scanner = new Scanner(System.in);

    /**
     * 登录
     *
     * @param bankUser
     * @return
     * @throws BankException
     */
    public boolean login(BankUser bankUser) throws BankException {
        if (bankUser == null) {
            throw new BankException("用户不能为空");
        }

        if (bankUser.getId() == null || bankUser.getPwd() == null) {
            throw new BankException("用户名或者密码不能为空");
        }
        if (bankUser.getId().equals("123456") && bankUser.getPwd().equals("111111")) {
            System.out.println("登录成功");
            return true;
        } else
            System.out.println("登录失败");
        return false;
    }

    /**
     * 取款
     *
     * @param bankUser
     * @throws BankException
     */
    public void putMoney(BankUser bankUser) throws BankException {
        System.out.println("请输入存款金额：");
        float money = scanner.nextFloat();
        if (money < 100 || money % 100 != 0 || money > 10000) {
            throw new BankException("存款金额必须大于100小于10000且是100的倍数");
        } else
            bankUser.setMoney(money + bankUser.getMoney()); //存入
    }

    /**
     * 取款
     *
     * @param bankUser
     */
    public void outMoney(BankUser bankUser) throws BankException {
        System.out.println("请输入取款金额：");
        float money = scanner.nextFloat();
        if (money < 100 || money % 100 != 0 || money > 2000) {
            throw new BankException("取款金额必须大于100小于2000且是100的倍数");
        } else if (money > bankUser.getMoney()) {
            throw new BankException("取款金额超出余额！");
        } else
            bankUser.setMoney(bankUser.getMoney() - money); //取出
    }

    /**
     * 显示余额
     * @param bankUser
     */
    public void show(BankUser bankUser){
        System.out.println("余额为："+bankUser.getMoney()+"元！");
    }
    public static void main(String[] args) {
        BankTest bt = new BankTest();
        boolean isLogin = false;
        BankUser user = new BankUser("123456", "111111", 8000);//初始化用户
        System.out.println("用户登录");
        boolean isFlag = true;
        while(isFlag){
            System.out.println("1.登录 2.取款 3.存款 4.查询余额 5.退出");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    //登录
                    try {
                        isLogin = bt.login(user);
                    } catch (BankException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    if(!isLogin){
                        System.out.println("用户未登录");
                    }else {
                        try {
                            bt.outMoney(user);
                        } catch (BankException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    if(!isLogin){
                        System.out.println("用户未登录");
                    }else{
                        try {
                            bt.putMoney(user);
                        } catch (BankException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                        break;
                case 4:
                    bt.show(user);
                    break;
                case 5:
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }
    }
}