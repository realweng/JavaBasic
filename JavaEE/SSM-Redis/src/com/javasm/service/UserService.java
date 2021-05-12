package com.javasm.service;

import com.javasm.entity.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/10-18:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface UserService {
    /**
     * 用户登录
     * @param userName
     * @param pwd
     * @return
     */
    User userLogin(@Param("userName")String userName, @Param("pwd")String pwd, HttpSession httpSession);
    User userLoginByRedis(@Param("userName")String userName, @Param("pwd")String pwd, HttpServletResponse httpServletResponse);

}
