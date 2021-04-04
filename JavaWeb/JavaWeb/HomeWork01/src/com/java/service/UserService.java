package com.java.service;

import com.java.entity.User;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-20:26
 * @Since:jdk1.8
 * @Description:业务处理层接口
 */
public interface UserService {
    /**
     * 用户
     * @param name
     * @param password
     * @return
     */
    public List<User> getUser(String name, String password);
}