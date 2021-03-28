package com.java.service;

import com.java.entity.User;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-15:05
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface UserService {
    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 查找用户
     * @param userName
     * @return
     */
    public List<User> findUserByName(String userName);
}
