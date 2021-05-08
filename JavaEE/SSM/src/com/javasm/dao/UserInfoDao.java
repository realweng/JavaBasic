package com.javasm.dao;

import com.javasm.entity.UserInfo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/7-17:31
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface UserInfoDao {
    /**
     * 通过id查找用户信息
     * @param userId
     * @return
     */
    UserInfo getUserInfo(Integer userId);

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    int addUserInfo(UserInfo userInfo);
}
