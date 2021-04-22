package com.javasm.service.impl;

import com.javasm.dao.MenuRoleDao;
import com.javasm.dao.impl.MenuRoleDaoImpl;
import com.javasm.service.MenuRoleService;
import com.javasm.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-19:11
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MenuRoleServiceImpl implements MenuRoleService {
    private MenuRoleDao menuRoleDao = new MenuRoleDaoImpl();
    /**
     * 给用户授权
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    @Override
    public boolean accreditAdminPower(Integer roleId, Integer[] menuIds) {
        Connection conn = JdbcUtil.getConnection();

        Boolean deleteMenuRole = false;
        Boolean insertMenuRole = false;
        try {
            conn.setAutoCommit(false);// 关闭mysql自动提交事务
            //1.删除该角色的所有的权限
            deleteMenuRole = menuRoleDao.deleteRole(conn, roleId);

            //2.将用户选中的权限赋给角色
            insertMenuRole = menuRoleDao.insertRole(conn, menuIds, roleId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (deleteMenuRole && insertMenuRole) {
                    conn.commit();// 如果两个操作都成功则提价事务
                } else {// 为操作成功则回滚事务
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return deleteMenuRole && insertMenuRole;
    }

    /**
     * 根据角色ID删除中间表(pn_menu_role)中的数据
     *
     * @param connection
     * @param roleId
     * @return
     */
    @Override
    public boolean deleteRole(Connection connection, Integer roleId) {
        return menuRoleDao.deleteRole(connection,roleId);
    }

    /**
     * 给角色赋权
     *
     * @param connection
     * @param menuIds
     * @param roleId
     * @return
     */
    @Override
    public boolean insertRole(Connection connection, Integer[] menuIds, Integer roleId) {
        return menuRoleDao.insertRole(connection, menuIds, roleId);
    }
}