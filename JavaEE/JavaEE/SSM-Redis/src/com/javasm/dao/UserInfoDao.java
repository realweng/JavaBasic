package com.javasm.dao;

import com.javasm.entity.UserInfo;

import java.util.List;

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

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    int updUserInfo(UserInfo userInfo);

    /**
     * 查询所有
     * @return
     * @param userInfo
     */
    List<UserInfo> findAll(UserInfo userInfo);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int delUserInfoById(Integer userId);

}
