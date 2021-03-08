package com.java.project.demo.test;

import com.java.project.demo.bean.User;
import com.java.project.demo.dao.UserDAO;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-17:54
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserTest {
    public static void main(String[] args) {
        User user1 = new User(7, "王五", "男", 25, "上海市静安区");
        UserDAO userDAO = new UserDAO();
//        userDAO.addUser(user1);//添加用户
        User user2 = userDAO.getUserById(3);
        System.out.println(user2.getUserId() + "\t" + user2.getUserName() + "\t" + user2.getUserGender() + "\t" + user2.getUserAge() + "\t" + user2.getUserAddr());
        List<User> list = userDAO.findAll();
        if(list.isEmpty()){
            System.out.println("没有记录");
        }else {
            for (User user : list) {
                System.out.println(user.getUserId() + "\t" + user.getUserName() + "\t" + user.getUserGender() + "\t" + user.getUserAge() + "\t" + user.getUserAddr());
            }
        }

    }
}