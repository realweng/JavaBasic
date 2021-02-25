package com.java.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-19:49
 * @Since:jdk1.8
 * @Description:作业5 管理员的测试类
 */

import com.java.student.bean.Manager;

import java.util.Scanner;

/**
 *
 */
public class ManagerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager("admin","123");
        System.out.println("请输入管理员的用户名:");
        String name = scanner.next();
        System.out.println("请输入密码：");
        String pwd = scanner.next();
        manager.confirm(name,pwd);
    }
}