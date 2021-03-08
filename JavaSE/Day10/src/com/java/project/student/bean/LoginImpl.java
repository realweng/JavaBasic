package com.java.project.student.bean;

import com.java.project.student.inter.UserLogin;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:45
 * @Since:jdk1.8
 * @Description:TODO
 */
public class LoginImpl implements UserLogin{
    private Teacher teacher;
    private Student student;
    private Scanner sc;
    /**
     * 构造器 初始化数据
     */
    public LoginImpl() {
        sc = new Scanner(System.in);
        teacher = new Teacher("1001","123456");
        student = new Student("9001","666666");
    }
    /**
     * 实现用户登录
     * 通过多态判断用户是哪个类型的（学生/教师）
     */
    @Override
    public void login(Person person) {
        if(person instanceof Student){ //如果这个对象是学生类的
            boolean isFlag = true;
            System.out.println("学生正在登录...");
            while (isFlag){
                System.out.println("请输入学生的id");
                String id = sc.next();
                if(student.getId().equals(id)){
                    System.out.println("用户名正确,请输入密码");
                    String pwd = sc.next();
                    if(student.getId().equals(id)&&student.getPwd().equals(pwd)){
                        System.out.println("用户名密码正确，登录成功！");
                        isFlag = false;
                    }else
                        System.out.println("用户名或密码输入错误，请重新输入！");
                } else
                    System.out.println("用户名输入错误，请重新登录");
            }

        }else {//如果这个对象是教师类的
            boolean isFlag = true;
            System.out.println("教师正在登录...");
            while (isFlag){
                System.out.println("请输入教师的id");
                String id = sc.next();
                if(teacher.getId().equals(id)){
                    System.out.println("用户名正确,请输入密码");
                    String pwd = sc.next();
                    if(teacher.getId().equals(id)&&teacher.getPwd().equals(pwd)){
                        System.out.println("用户名密码正确，登录成功！");
                        isFlag = false;
                    }else
                        System.out.println("用户名或密码输入错误，请重新输入！");
                } else
                    System.out.println("用户名输入错误，请重新登录");
            }
        }
    }
}