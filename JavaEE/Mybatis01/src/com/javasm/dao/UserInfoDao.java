package com.javasm.dao;

import com.javasm.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/26-19:52
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface UserInfoDao {
    /**
     * 通过id获取用户
     * @param id
     * @return
     */
    UserInfo getUser(Object id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<UserInfo> findAllUserInfo();

    /**
     * 传入对象 按条件查询
     * @param userInfo
     * @return
     */
    List<UserInfo> findAll(UserInfo userInfo);

    /**
     * 通过map按条件查询
     * @param map
     * @return
     */
    List<UserInfo> findAllByMap(Map<String,Object> map);

    /**
     * 多参数查询
     * @param username  用户名
     * @param userSalary 薪水
     * @return
     */
    List<UserInfo> findAll(@Param("userName") String username, @Param("userSalary") Float userSalary);
}
