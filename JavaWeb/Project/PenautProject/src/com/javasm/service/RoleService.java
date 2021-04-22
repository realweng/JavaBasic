package com.javasm.service;

import com.javasm.entity.Role;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-15:29
 * @Since:jdk1.8
 * @Description:角色业务处理层
 */
public interface RoleService {
    public List<Role> findAllRole();
}
