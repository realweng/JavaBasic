package com.javasm.service.impl;

import com.javasm.dao.UserInfoDao;
import com.javasm.entity.UserInfo;
import com.javasm.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 修改用户信息
     *
     * @param userInfo
     * @return
     */
    @Override
    public int updUserInfo(UserInfo userInfo) {
        return userInfoDao.updUserInfo(userInfo);
    }

    /**
     * 查询所有
     *
     * @param userInfo
     * @return
     */
    @Override
    public List<UserInfo> findAll(UserInfo userInfo) {
        return userInfoDao.findAll(userInfo);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @Override
    public int delUserInfoById(Integer userId) {
        return userInfoDao.delUserInfoById(userId);
    }
}