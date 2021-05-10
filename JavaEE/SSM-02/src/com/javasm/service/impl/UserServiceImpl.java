package com.javasm.service.impl;

import com.javasm.dao.UserDao;
import com.javasm.entity.User;
import com.javasm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /**
     * 用户登录
     *
     * @param userName
     * @param pwd
     * @return
     */
    @Override
    public User userLogin(String userName, String pwd, HttpSession httpSession) {
        User user = userDao.userLogin(userName,pwd);
        if (user!=null){
            httpSession.setAttribute("user",user);
        }
        return user;
    }
}