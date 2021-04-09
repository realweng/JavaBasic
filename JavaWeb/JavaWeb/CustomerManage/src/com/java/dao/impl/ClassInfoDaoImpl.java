package com.java.dao.impl;

import com.java.dao.ClassInfoDao;
import com.java.entity.ClassInfo;
import com.java.util.JDBCUtil;
import jdk.nashorn.internal.scripts.JD;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/7-22:18
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClassInfoDaoImpl implements ClassInfoDao {

    /**
     * 增加班级信息
     *
     * @param classInfo
     * @return
     */
    @Override
    public int addClassInfo(ClassInfo classInfo) {
        String sql = "INSERT into `classInfo` values(null,?,?,?);";
        return JDBCUtil.update(sql,classInfo.getClassName(),classInfo.getClassDate(),classInfo.getClassNote());
    }

    /**
     * 删除班级信息
     *
     * @param id
     * @return
     */
    @Override
    public int delClassInfoById(Integer id) {
        String sql = "DELETE from classinfo where classId = ?";
        return JDBCUtil.update(sql,id);
    }

    /**
     * 修改班级信息
     *
     * @param classInfo
     * @return
     */
    @Override
    public int updateClassInfo(ClassInfo classInfo) {
        String sql = "UPDATE classinfo SET className=?,classDate=?,classNote = ? where classId = ?";
        return JDBCUtil.update(sql,classInfo.getClassName(),classInfo.getClassDate(),classInfo.getClassNote(),classInfo.getClassId());
    }

    /**
     * 查询所有班级信息
     *
     * @return
     */
    @Override
    public List<ClassInfo> findAllClassInfo() {
        String sql = "select * from classInfo";
        return JDBCUtil.query(sql,ClassInfo.class);
    }
}