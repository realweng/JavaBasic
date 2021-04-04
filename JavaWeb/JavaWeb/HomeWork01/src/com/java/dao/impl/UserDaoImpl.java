package com.java.dao.impl;

import com.java.dao.UserDao;
import com.java.entity.User;
import com.java.util.JDBCUtil;
import jdk.nashorn.internal.scripts.JD;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-20:23
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserDaoImpl implements UserDao {
    /**
     * 得到用户
     * @param name
     * @param password
     * @return
     */
    @Override
    public List<User> getUser(String name, String password) {
        String sql = "select * from user where name = ? and password = ?";
        return JDBCUtil.query(sql,User.class,name,password);
    }
}