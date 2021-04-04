package com.java.dao;

import com.java.entity.User;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-20:21
 * @Since:jdk1.8
 * @Description:用户数据层接口
 */
public interface UserDao {
    /**
     * 得到用户
     * @param name
     * @param password
     * @return
     */
    public List<User> getUser(String name, String password);
}