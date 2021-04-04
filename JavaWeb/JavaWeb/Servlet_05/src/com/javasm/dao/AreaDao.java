package com.javasm.dao;

import com.javasm.entity.Area;

import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/4/2-16:54
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface AreaDao {

    /**
     * 通过地址的级别查询地址信息
     *
     * @param level 地址的级别
     * @return
     */
    List<Area> findAreaByLevel(Integer level);

    /**
     * 通过parentId查询子级地址
     *
     * @param parentId
     * @return
     */
    List<Area> findAreaByParentId(Integer parentId);
}
