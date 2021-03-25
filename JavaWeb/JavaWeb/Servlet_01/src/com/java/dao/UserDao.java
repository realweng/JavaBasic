package com.java.dao;

import com.java.entity.User;
import com.java.util.JDBCUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/25-20:29
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserDao {
    //添加用户信息
    public int addUser(User user) {
        int i = 0;
        String sql = "INSERT INTO `user` VALUES(NULL,?,?,?,?,?,?,?)";
        i = JDBCUtil.update(sql, user.getUserName(), user.getPwd(), user.getSex(), user.getAihaos(), user.getAddress(), user.getMyFile(), user.getRegisterDate());
        return i;
    }

    //通过userName查询user信息
    public List<User> findUserByName(String userName) {
        List userList = new ArrayList<User>(10);
        String sql = "SELECT * from `user` WHERE userName = ?";
        userList = JDBCUtil.query(sql,User.class,userName);
        return userList;
    }
}