package com.javasm.service;
import java.sql.Connection;
/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-19:08
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface MenuRoleService {
    /**
     * 给用户授权
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    boolean accreditAdminPower(Integer roleId, Integer[] menuIds);

    /**
     * 根据角色ID删除中间表(pn_menu_role)中的数据
     *
     * @param roleId
     * @return
     */
    boolean deleteRole(Connection connection, Integer roleId);

    /**
     * 给角色赋权
     *
     * @param menuIds
     * @param roleId
     * @return
     */
    boolean insertRole(Connection connection, Integer[] menuIds, Integer roleId);
}