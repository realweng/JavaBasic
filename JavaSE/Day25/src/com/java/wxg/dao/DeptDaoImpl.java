package com.java.wxg.dao;

import com.java.wxg.bean.Dept;
import com.java.wxg.dao.DeptDao;
import com.java.wxg.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-16:37
 * @Since:jdk1.8
 * @Description:TODO
 */
public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> showAllDept() {
        String sql = "select * from tb_depart";
        List<Dept> list = new ArrayList<>(10);
        list = JDBCUtil.executeQuery(sql,Dept.class);
        return list;
    }
}