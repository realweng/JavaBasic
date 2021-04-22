package com.javasm.dao;

import java.sql.Connection;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-17:51
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface MenuRoleDao {
    /**
     * 根据角色id删除中间表的数据
     * @param roleId
     * @return
     */
    boolean deleteRole(Connection connection,Integer roleId);

    /**
     * 添加权限
     * @param menuIds
     * @param roleId
     * @return
     */
    boolean insertRole(Connection connection,Integer[] menuIds, Integer roleId);
}
