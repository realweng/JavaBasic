package com.java.service;

import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/25-20:30
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserService {
    private UserDao userDao = new UserDao();

    //添加用户信息
    public int addUser(User user) {
        int i = 0;
        i = userDao.addUser(user);
        return i;
    }

    //通过userName查询user信息
    public List<User> findUserByName(String userName) {
        List userList = new ArrayList<User>(10);
        userList = userDao.findUserByName(userName);
        return userList;
    }
}