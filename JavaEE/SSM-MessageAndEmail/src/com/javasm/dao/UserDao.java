package com.javasm.dao;

import com.javasm.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/10-18:10
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface UserDao {
    /**
     * 用户登录
     * @param userName
     * @param pwd
     * @return
     */
    User userLogin(@Param("userName")String userName,@Param("pwd")String pwd);

    /**
     * 添加用户并返回当前添加用户的uid
     * @return
     */
    Integer addUser(@Param("userName")String userName,@Param("pwd")String pwd);
}
