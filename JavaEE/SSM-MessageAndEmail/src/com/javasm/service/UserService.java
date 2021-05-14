package com.javasm.service;

import com.javasm.entity.DataModel;
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
     *
     * @param userName
     * @param pwd
     * @param httpSession
     * @return
     */
    User userLogin(@Param("userName")String userName, @Param("pwd")String pwd, HttpSession httpSession);

    /**
     *
     * @param userName
     * @param pwd
     * @param httpServletResponse
     * @return
     */
    User userLoginByRedis(@Param("userName")String userName, @Param("pwd")String pwd, HttpServletResponse httpServletResponse);

    /**
     * 注册用户
     * @param userName
     * @param pwd
     * @return 返回uid
     */
    DataModel register(String userName, String pwd,String phone,String code);

    /**
     * 发送注册验证码
     * @param phoneNum
     * @return
     */
    DataModel getCode(String phoneNum);
}
