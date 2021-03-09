package com.java.wxg.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-15:56
 * @Since:jdk1.8
 * @Description:TODO
 */

import com.java.wxg.demo.bean.BankUser;
import java.util.Scanner;

/**
 * 银行账户测试类
 */
public class BankTest {
    static Scanner scanner = new Scanner(System.in);
    static boolean isLogin = false;

    //登录
    public void login(BankUser user){
        System.out.println("请输入卡号：");
        String userNo = scanner.next();
        System.out.println("请输入密码：");
        String pwd = scanner.next();
        if(userNo.equals(user.userNo) && pwd.equals(user.pwd)){
            System.out.println("登录成功");
            isLogin = true;
            boolean isFlag = true; //判断是否退出
            while (isFlag){
                System.out.println("请选择你需要进行的操作：");
                System.out.println("1、取款 2、存款 3、查询余额 4、退出");
                int select = scanner.nextInt();
                switch (select){
                    case 1:
                        outMoney(user);
                        break;
                    case 2:
                        inMoney(user);
                        break;
                    case 3:
                        haveMoney(user);
                        break;
                    case 4:
                        isFlag = false;
                        break;
                    default:
                        System.out.println("选择错误");
                        break;
                }
            }
        }else
            System.out.println("密码输入错误");
    }
    //取款
    public void outMoney(BankUser user){
        if(isLogin){
            System.out.println("请输入取款金额");
            float money = scanner.nextFloat();
            if(user.money - money < 0){
                System.out.println("余额不足请重新输入！");
            }else{
                user.money = user.money - money;
            }
        }else
            return;
    }

    //存款
    public void inMoney(BankUser user){
        if(isLogin){
            System.out.println("请输入存款金额：");
            float money = scanner.nextFloat();
            user.money = user.money + money;
        }
    }
    //查询余额
    public void haveMoney(BankUser user){
        if(isLogin){
            System.out.println("账户余额为："+user.money);
        }else
            return;
    }
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        BankUser bankUser = new BankUser("1234","123456",5000);
        BankTest test = new BankTest();
        test.login(bankUser);
    }
}