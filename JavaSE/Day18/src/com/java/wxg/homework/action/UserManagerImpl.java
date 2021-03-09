package com.java.wxg.homework.action;

import com.java.wxg.homework.action.Impl.UserManager;
import com.java.wxg.homework.demo.User;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-19:53
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserManagerImpl implements UserManager {
    Scanner scanner = new Scanner(System.in);

    /**
     * 添加用户
     *
     * @param list
     */
    @Override
    public void addUser(List<User> list) {
        if (list != null) {
            System.out.println("请输入用户的基本信息：");
            String name = scanner.next();
            int age = scanner.nextInt();
            String gender = scanner.next();
            String addr = scanner.next();
            User user = new User(name, age, gender, addr);
            list.add(user);
        }
    }

    /**
     * 删除用户
     *
     * @param list
     */
    @Override
    public void delUser(List<User> list, int id) {
        if (list != null) {
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    index = i;
                }
            }
            if (index != -1) {
                list.remove(index);
            } else
                System.out.println("不存在该id!");
        }
    }

    /**
     * 修改用户
     *
     * @param list
     */
    @Override
    public void replaceUser(List<User> list, int id) {
        if (list != null) {
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    index = i;
                }
            }
            if (index != -1) {
                System.out.println("请输入要修改的的基本信息：");
                String name = scanner.next();
                int age = scanner.nextInt();
                String gender = scanner.next();
                String addr = scanner.next();
                User user = new User(name, age, gender, addr);
                list.set(index,user);
            } else
                System.out.println("不存在该id!");
        }
    }

    /**
     * 通过id查找用户
     *
     * @param list
     * @param id
     */
    @Override
    public void findUserById(List<User> list, int id) {
        if (list != null) {
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    index = i;
                }
            }
            if (index != -1) {
                System.out.println("id\t名字\t年龄\t性别\t地址");
                System.out.println(list.get(index).getId()+"\t"+list.get(index).getName()+"\t"+list.get(index).getAge()
                        +"\t"+list.get(index).getGender()+"\t"+list.get(index).getAddr());
            } else
                System.out.println("不存在该id!");
        }
    }

    /**
     * 显示所有用户
     *
     * @param list
     */
    @Override
    public void show(List<User> list) {
        System.out.println("id\t名字\t年龄\t性别\t地址");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId()+"\t"+list.get(i).getName()+"\t"+list.get(i).getAge()
                    +"\t"+list.get(i).getGender()+"\t"+list.get(i).getAddr());
        }
    }
}