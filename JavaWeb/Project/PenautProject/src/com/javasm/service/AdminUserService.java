package com.javasm.service;

import com.javasm.entity.AdminUser;
import com.javasm.util.PageInfo;
import com.javasm.vo.AdminUserEntity;

import java.util.List;

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

    /**
     * 通过分页查询用户信息
     * @param nowPage
     * @param pageNum
     * @return
     */
    public PageInfo<AdminUserEntity> findAllAdminUser(String nowPage, String pageNum);

    /**
     * 通过id 删除用户
     * @param id
     * @return
     */
    public boolean deleteUserById(Integer id);

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    public AdminUser findAdminById(Integer id);
    /**
     * 添加管理员用户
     */

    public boolean addUser(AdminUser adminUser);
}
