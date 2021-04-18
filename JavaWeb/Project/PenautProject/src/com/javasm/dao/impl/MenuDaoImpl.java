package com.javasm.dao.impl;

import com.javasm.dao.MenuDao;
import com.javasm.entity.Menu;
import com.javasm.util.JdbcUtil;
import com.javasm.vo.MenuEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/18-17:25
 * @Since:jdk1.8
 * @Description:目录数据层接口实现类
 */
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {

    /**
     * 通过角色id找对应的菜单
     *
     * @param roleId
     * @return
     */
    @Override
    public List<MenuEntity> findMenuByRoleId(Integer roleId) {
        String sql = "select m.*,r.rolename from menu m,roleandmenu mr,role r WHERE m.mid = mr.menuid and" +
                " r.rid = mr.rid and mr.rid = ? and m.state = 1 and r.state = 1 and m.parentid = 0";
        return JdbcUtil.query(sql,MenuEntity.class,roleId);
    }

    /**
     * 通过父级id找子目录
     *
     * @param parentId
     * @return
     */
    @Override
    public List<MenuEntity> findMenuByParentId(Integer parentId) {
        String sql = "SELECT * from menu where parentId = ? and state = 1";
        return JdbcUtil.query(sql,MenuEntity.class,parentId);
    }
}