package com.java.project.homework.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-21:43
 * @Since:jdk1.8
 * @Description:作业9
 */

import java.util.Scanner;

/**
 * 实现用户注册，要求使用正则表达式要求：
 * 账号不能包含数字。密码长度6-10位，必须包含大写字母。
 */
public class Homework9 {
    static Scanner scanner = new Scanner(System.in);

    /**
     * 用户注册方法
     * 返回注册结果
     */
    public static boolean register() {
        System.out.println("请输入注册账号");
        String uidRegex = "^([A-Za-z]+)$";
        String uid = scanner.next();
        if (uid.matches(uidRegex)) {
            System.out.println("用户名符号规范，请继续输入密码");
            String pwdRegex = "^(?![^a-zA-Z]+$)(?!\\D+$).{6,10}$";
            String pwd = scanner.next();
            if (pwd.matches(pwdRegex)) {
                System.out.println("注册成功！");
                return true;
            } else {
                System.out.println("密码不合规范");
                return false;
            }
        } else {
            System.out.println("用户名不符合规范");
            return false;
        }
    }

    public static void main(String[] args) {
        register();
    }
}