package com.javasm.dao;

import com.javasm.entity.AdminUser;
import com.javasm.util.PageInfo;
import com.javasm.vo.AdminUserEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/12-18:56
 * @Since:jdk1.8
 * @Description:后台管理用户数据处理接口
 */
public interface AdminUserDao extends BaseDao<AdminUser>{
    /**
     * 通过用户名查找用户信息
     * @param name
     * @return
     */
    public AdminUser findUserByName(String name);

    /**
     * 查询所有用户
     */
    public List<AdminUserEntity> findAllAdminUser(PageInfo<AdminUserEntity> pageInfo);

    public Integer countAll();
}
