package com.javasm.service.impl;

import com.javasm.dao.MenuDao;
import com.javasm.dao.impl.MenuDaoImpl;
import com.javasm.service.MenuService;
import com.javasm.vo.MenuEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/18-19:26
 * @Since:jdk1.8
 * @Description:菜单业务处理接口实现类
 */
public class MenuServiceImpl implements MenuService {
    private MenuDao menuDao = new MenuDaoImpl();

    /**
     * 通过角色id找对应的菜单
     *
     * @param roleId
     * @return
     */
    @Override
    public List<MenuEntity> findMenuByRoleId(Integer roleId) {
        return menuDao.findMenuByRoleId(roleId);
    }

    /**
     * 通过父级id找子目录
     *
     * @param parentId
     * @return
     */
    @Override
    public List<MenuEntity> findMenuByParentId(Integer parentId) {
        return menuDao.findMenuByParentId(parentId);
    }

    /**
     * 通过用户的角色id查询用户对应的菜单
     *
     * @param roleId
     * @return
     */
    @Override
    public List<MenuEntity> showMenuByUserRoleId(Integer roleId) {
        // 查询用户的一级菜单
        List<MenuEntity> list = menuDao.findMenuByRoleId(roleId);

        // 遍历集合查询一级菜单的二级菜单
        for (MenuEntity menuEntity : list) {
            List<MenuEntity> menuByParentId = menuDao.findMenuByParentId(menuEntity.getMid());
            if (menuByParentId != null && menuByParentId.size() > 0) {
                menuEntity.setSonList(menuByParentId);
            }
        }
        return list;
    }


}