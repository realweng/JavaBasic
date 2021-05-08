package com.javasm.service.impl;

import com.javasm.dao.UserInfoDao;
import com.javasm.entity.UserInfo;
import com.javasm.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/7-17:42
 * @Since:jdk1.8
 * @Description:TODO
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    /**
     * 通过id查找用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public UserInfo getUserInfo(Integer userId) {
        UserInfo userInfo = userInfoDao.getUserInfo(userId);
        return userInfo;
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @return
     */
    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoDao.addUserInfo(userInfo);
    }
}