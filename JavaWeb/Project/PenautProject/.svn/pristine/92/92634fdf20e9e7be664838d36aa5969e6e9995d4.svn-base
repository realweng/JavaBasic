package com.javasm.service;

import com.javasm.vo.MenuEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/18-19:25
 * @Since:jdk1.8
 * @Description:菜单业务处理层接口
 */
public interface MenuService {
    /**
     * 通过角色id找对应的菜单
     * @param roleId
     * @return
     */
    public List<MenuEntity> findMenuByRoleId(Integer roleId);

    /**
     * 通过父级id找子目录
     * @param parentId
     * @return
     */
    public List<MenuEntity> findMenuByParentId(Integer parentId);

    /**
     * 通过用户的角色id查询用户对应的菜单
     * @param roleId
     * @return
     */
    List<MenuEntity> showMenuByUserRoleId(Integer roleId);
}