package com.java.project.project.service;

import com.java.project.project.bean.Dept;
import com.java.project.project.dao.DeptDao;
import com.java.project.project.dao.impl.DeptDaoImpl;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-16:41
 * @Since:jdk1.8
 * @Description:TODO
 */
public class DeptService {
    DeptDao deptDao = new DeptDaoImpl();
    public List<Dept> showAllDept(){
        return deptDao.showAllDept();
    }
}