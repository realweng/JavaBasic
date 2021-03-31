package com.java.dao;

import com.java.entity.User;
import com.java.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/28-15:02
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 通过userName查询user信息
     * @param userName
     * @return
     */
    public List<User> findUserByName(String userName);
}
