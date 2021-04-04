package com.javasm.dao.impl;

import com.javasm.dao.AreaDao;
import com.javasm.entity.Area;
import com.javasm.util.JDBCUtils;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/4/2-16:57
 * @Since:jdk1.8
 * @Description:TODO
 */
public class AreaDaoImpl implements AreaDao {
    private Class<Area> clazz = Area.class;

    @Override
    public List<Area> findAreaByLevel(Integer level) {
        String sql = "select * from area where areaLevel=?";
        return JDBCUtils.query(sql, clazz, level);
    }

    @Override
    public List<Area> findAreaByParentId(Integer parentId) {
        String sql = "select * from area where parentId=?";
        return JDBCUtils.query(sql, clazz, parentId);
    }
}
