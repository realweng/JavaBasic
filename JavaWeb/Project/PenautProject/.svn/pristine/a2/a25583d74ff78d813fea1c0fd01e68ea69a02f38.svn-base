package com.javasm.service.impl;

import com.javasm.dao.SuggestionDao;
import com.javasm.dao.UserDao;
import com.javasm.dao.impl.SuggestionDaoImpl;
import com.javasm.dao.impl.UserDaoImpl;
import com.javasm.entity.Suggestion;
import com.javasm.entity.User;
import com.javasm.service.UserService;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-22:59
 * @Since:jdk1.8
 * @Description:TODO
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private SuggestionDao suggestionDao = new SuggestionDaoImpl();

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        return userDao.add(user);
    }

    @Override
    public boolean addSuggestion(Suggestion suggestion) {
        return suggestionDao.add(suggestion);
    }

    @Override
    public User findUserByNamePwd(String name, String pwd) {
        return userDao.login(name, pwd);
    }

    @Override
    public User findUserById(Integer id) {
        User user = new User();
        user.setUid(id);
        return userDao.select(user);
    }
}