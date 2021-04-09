package com.java.dao;

import com.java.entity.ClassInfo;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface ClassInfoDao {
    /**
     * 增加班级信息
     * @param classInfo
     * @return
     */
    public int addClassInfo(ClassInfo classInfo);

    /**
     * 删除班级信息
     * @param id
     * @return
     */
    public int delClassInfoById(Integer id);

    /**
     * 修改班级信息
     * @param classInfo
     * @return
     */
    public int updateClassInfo(ClassInfo classInfo);

    /**
     * 查询所有班级信息
     * @return
     */
    public List<ClassInfo> findAllClassInfo();
}
