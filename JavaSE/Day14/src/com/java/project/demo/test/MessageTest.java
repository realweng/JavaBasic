package com.java.project.demo.test;

import com.java.project.demo.bean.User;
import com.java.project.demo.util.MessageUtil;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/3-17:59
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MessageTest {
    private static User user = new User();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 用户注册
     */
    public static void register() {
        System.out.println("请输入用户注册id");
        String secId = scanner.next();
        user.setId(MessageUtil.encryption(secId));
        System.out.println("请输入用户注册密码");
        String secPwd = scanner.next();
        user.setPwd(MessageUtil.encryption(secPwd));
    }

    /**
     * 用户登录
     */
    public static void login(){
        System.out.println("请输入用户登录id");
        String secId = scanner.next();
        secId = MessageUtil.encryption(secId);
        System.out.println("请输入用户登录密码");
        String secPwd = scanner.next();
        secPwd = MessageUtil.encryption(secPwd);
        if(secId.equals(user.getId())&&secPwd.equals(user.getPwd())){
            System.out.println("登录成功！");
        }
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        register();
        login();
    }
}