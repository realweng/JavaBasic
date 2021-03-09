package com.java.wxg.service;

import com.java.wxg.bean.Dept;
import com.java.wxg.dao.DeptDao;
import com.java.wxg.dao.DeptDaoImpl;

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