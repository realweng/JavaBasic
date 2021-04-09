package com.java.service.impl;

import com.java.dao.ClassInfoDao;
import com.java.dao.impl.ClassInfoDaoImpl;
import com.java.entity.ClassInfo;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClassInfoServiceImpl implements ClassInfoDao {
    private ClassInfoDao classInfoDao = new ClassInfoDaoImpl();
    /**
     * 增加班级信息
     *
     * @param classInfo
     * @return
     */
    @Override
    public int addClassInfo(ClassInfo classInfo) {
        return classInfoDao.addClassInfo(classInfo);
    }

    /**
     * 删除班级信息
     *
     * @param id
     * @return
     */
    @Override
    public int delClassInfoById(Integer id) {
        return classInfoDao.delClassInfoById(id);
    }

    /**
     * 修改班级信息
     *
     * @param classInfo
     * @return
     */
    @Override
    public int updateClassInfo(ClassInfo classInfo) {
        return classInfoDao.updateClassInfo(classInfo);
    }

    /**
     * 查询所有班级信息
     *
     * @return
     */
    @Override
    public List<ClassInfo> findAllClassInfo() {
        return classInfoDao.findAllClassInfo();
    }
}