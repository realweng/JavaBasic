package com.java.service.impl;

import com.java.dao.UserDao;
import com.java.dao.impl.UserDaoImpl;
import com.java.entity.User;
import com.java.service.UserService;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-20:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    /**
     * 用户
     * @param name
     * @param password
     * @return
     */
    @Override
    public List<User> getUser(String name, String password) {
        return userDao.getUser(name,password);
    }
}