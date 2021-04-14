package com.javasm.dao.impl;

import com.javasm.dao.AdminUserDao;
import com.javasm.entity.AdminUser;
import com.javasm.util.JdbcUtil;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/12-18:57
 * @Since:jdk1.8
 * @Description:后台管理用户数据处理接口实现类
 */
public class AdminUserDaoImpl extends BaseDaoImpl<AdminUser> implements AdminUserDao {
    /**
     * 通过用户名密码查找用户信息
     * @param name
     * @return
     */
    @Override
    public AdminUser findUserByName(String name) {
        String sql = "select * from AdminUser where username = ?";
        return JdbcUtil.queryObject(sql,AdminUser.class,name);
    }

}