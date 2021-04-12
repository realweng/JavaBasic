package com.javasm.service;

import com.javasm.entity.AdminUser;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/12-19:24
 * @Since:jdk1.8
 * @Description:后台管理业务处理接口
 */
public interface AdminUserService {
    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    public AdminUser findUserByName(String name);

    /**
     * 后台管理用户改密码
     * @param adminUser
     */
    public boolean updatePassWord(AdminUser adminUser);
}
