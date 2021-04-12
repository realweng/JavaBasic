package com.javasm.service.impl;

import com.javasm.dao.AdminUserDao;
import com.javasm.dao.impl.AdminUserDaoImpl;
import com.javasm.entity.AdminUser;
import com.javasm.service.AdminUserService;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/12-19:59
 * @Since:jdk1.8
 * @Description:后台管理业务处理接口
 */
public class AdminUserServiceImpl implements AdminUserService {
    private AdminUserDao adminUserDao = new AdminUserDaoImpl();
    /**
     * 通过用户名查找用户是否存在
     * @param name
     * @return
     */
    @Override
    public AdminUser findUserByName(String name) {
        return adminUserDao.findUserByName(name);
    }

    /**
     * 后台管理用户改密码
     *
     * @param adminUser
     */
    @Override
    public boolean updatePassWord(AdminUser adminUser) {
        return adminUserDao.update(adminUser);
    }
}