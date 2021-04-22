package com.javasm.dao.impl;

import com.javasm.dao.MenuRoleDao;
import com.javasm.util.JdbcUtil;

import java.sql.Connection;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-17:52
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MenuRoleDaoImpl implements MenuRoleDao {

    /**
     * 根据角色id删除中间表的数据
     *
     * @param roleId
     * @return
     */
    @Override
    public boolean deleteRole(Connection connection,Integer roleId) {
        String sql = "delete from roleandmenu where rid=?";
        return JdbcUtil.update(sql, roleId) > 0;
    }

    /**
     * 添加权限
     *
     * @param menuIds
     * @param roleId
     * @return
     */
    @Override
    public boolean insertRole(Connection connection,Integer[] menuIds, Integer roleId) {
        String sql = "insert into roleandmenu values(" + roleId + ",?) ";
        Integer[][] menuIdArray = new Integer[menuIds.length][];// 高维确定执行sql语句的次数，低维是给问号赋值
        for (int i = 0; i < menuIds.length; i++) {
            menuIdArray[i] = new Integer[]{menuIds[i]};
        }
        int[] ints = JdbcUtil.insertMore(connection, sql, menuIdArray);
        return ints != null && ints.length > 0;
    }
}