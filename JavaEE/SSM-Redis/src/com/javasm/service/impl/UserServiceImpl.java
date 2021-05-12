package com.javasm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.constants.Constants;
import com.javasm.constants.RedisKeyConstants;
import com.javasm.dao.UserDao;
import com.javasm.entity.User;
import com.javasm.service.RedisService;
import com.javasm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/10-18:17
 * @Since:jdk1.8
 * @Description:TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private RedisService redisService;

    /**
     * 用户登录
     *
     * @param userName
     * @param pwd
     * @return
     */
    @Override
    public User userLogin(String userName, String pwd, HttpSession httpSession) {
        User user = userDao.userLogin(userName, pwd);
        if (user != null) {
            httpSession.setAttribute("user", user);
        }
        return user;
    }

    /**
     * 用redis模拟session进行登录状态验证
     *
     * @param userName
     * @param pwd
     * @param
     * @param httpServletResponse
     * @return
     */
    @Override
    public User userLoginByRedis(String userName, String pwd, HttpServletResponse httpServletResponse) {
        User user = userDao.userLogin(userName, pwd);
        if (user != null) {
            Cookie cookie = new Cookie("id",user.getUid().toString());
            cookie.setPath("/");
            httpServletResponse.addCookie(cookie);

            //将id存到redis中
            String sessionKey = RedisKeyConstants.USER_SESSION_KEY+user.getUid().toString();
            redisService.setex(sessionKey, Constants.REDIS_SESSION_EXPIRE, JSON.toJSONString(user));
        }
        return user;
    }
}