package com.javasm.service.impl;

import com.javasm.dao.RoleDao;
import com.javasm.dao.impl.RoleDaoImpl;
import com.javasm.entity.Role;
import com.javasm.service.RoleService;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-15:30
 * @Since:jdk1.8
 * @Description:角色业务处理层接口实现类
 */
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao = new RoleDaoImpl();
    /**
     * 查询所有的角色
     * @return
     */
    @Override
    public List<Role> findAllRole() {
        return roleDao.findAll();
    }
}