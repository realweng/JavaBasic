package com.java.service.impl;

import com.java.dao.UserDao;
import com.java.dao.impl.UserDaoImpl;
import com.java.entity.User;
import com.java.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-15:08
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

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