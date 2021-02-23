package com.java.homework.action.Impl;

import com.java.homework.bean.User;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-19:48
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface UserManager {
    /**
     * 添加用户
     */
    public void addUser(List<User> list);
    /**
     * 删除用户
     */
    public void delUser(List<User> list,int id);
    /**
     * 修改用户
     */
    public void replaceUser(List<User> list,int id);

    /**
     * 通过id查找用户
     */
    public void findUserById(List<User> list,int id);

    /**
     * 显示所有用户
     */
    public void show(List<User> list);
}
