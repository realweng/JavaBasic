package com.javasm.dao;

import com.javasm.entity.Menu;
import com.javasm.vo.MenuEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/18-17:22
 * @Since:jdk1.8
 * @Description:目录数据层接口
 */
public interface MenuDao extends BaseDao<Menu>{
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
}