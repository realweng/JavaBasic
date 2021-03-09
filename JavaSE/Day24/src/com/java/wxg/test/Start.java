package com.java.wxg.test;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/7-22:43
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Start {
    private Scanner scanner = new Scanner(System.in);
    private static int id = -1; //正在登录的id
    private static boolean isLogin = false;//是否正在登录

    /**
     * 程序执行主菜单
     */
    public void menu() {
        boolean isFlag = true;

        while (isFlag) {
            System.out.println("***************欢迎使用XX公司打卡系统*****************");
            System.out.println("1、登录");
            System.out.println("2、注册");
            System.out.println("0、退出");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("您已经选择1、登录");
                    loginMenu();
                    break;
                case 2:
                    System.out.println("您已经选择2、注册");
                    register();
                    break;
                case 0:
                    System.out.println("退出中...");
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 登录菜单
     */
    public void loginMenu() {

    }

    /**
     * 用户登录操作 返回登录成功的id
     */
    public void login() {

    }

    /**
     * 用户注册操作
     */
    public void register() {

    }

    /**
     * 打卡操作
     */
    public void clickIn() {

    }

    /**
     * 更改个人信息
     */
    public void updateInfo() {

    }
}