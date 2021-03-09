package com.java.wxg.homework.test;

import com.java.wxg.homework.action.Impl.UserManagerImpl;
import com.java.wxg.homework.demo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-19:56
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Start {
    private List<User> list;
    private User users[];
    private Scanner scanner;
    private UserManagerImpl userManagerImpl = new UserManagerImpl();

    /**
     * 初始化数据
     */
    public Start() {
        scanner = new Scanner(System.in);
        init();
    }

    /**
     * 初始化数据
     */
    public void init(){
        list = new ArrayList<>(16);
        users = new User[2];
        users[0] = new User("zsan",21,"男","安徽省芜湖市");
        users[1] = new User("cat",22,"女","浙江省杭州市");
        list.add(users[0]);
        list.add(users[1]);
    }

    public void menu(){
        boolean isFlag = true;
        while (isFlag){
            System.out.println("1、添加用户");
            System.out.println("2、删除用户");
            System.out.println("3、修改用户");
            System.out.println("4、查询用户");
            System.out.println("5、通过id查用户");
            System.out.println("0、退出");
            System.out.println("请选择：");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    replace();
                    break;
                case 4:
                    show();
                    break;
                case 5:
                    findById();
                    break;
                case 0:
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }
    }

    public void add(){
        userManagerImpl.addUser(list);
    }

    public void delete(){
        System.out.println("请输入要删除的编号：");
        int id = scanner.nextInt();
        userManagerImpl.delUser(list,id);
    }

    public void replace(){
        System.out.println("请输入要修改用户的编号");
        int id = scanner.nextInt();
        userManagerImpl.replaceUser(list,id);
    }

    public void show(){
        userManagerImpl.show(list);
    }

    public void findById(){
        System.out.println("请输入要查找的编号：");
        int id = scanner.nextInt();
        userManagerImpl.findUserById(list,id);
    }
}