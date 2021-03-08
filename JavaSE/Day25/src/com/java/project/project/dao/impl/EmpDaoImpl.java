package com.java.project.project.dao.impl;

import com.java.project.project.bean.Emp;
import com.java.project.project.dao.EmpDao;
import com.java.project.project.util.JDBCUtil;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-14:14
 * @Since:jdk1.8
 * @Description:TODO
 */
public class EmpDaoImpl implements EmpDao {
    /**
     * 登录
     * @param empId
     * @param empPwd
     * @return
     */
    @Override
    public Emp login(Integer empId, String empPwd) {
        Emp emp = null;
        String sql = "select * from tb_emp where emp_id = ? and emp_pwd = ?";
        List<Emp> list = JDBCUtil.executeQuery(sql, Emp.class, empId, empPwd);
        //判断list
        if(!list.isEmpty()){
            emp = list.get(0);
        }
        return emp;
    }

    /**
     * 注册
     * @param emp
     * @return
     */
    @Override
    public int register(Emp emp) {
        String sql = "INSERT into tb_emp values(null,?,?,?,?,?,?)";
        return JDBCUtil.executeUpdate(sql,emp.getEmpUname(),emp.getEmpPwd(),emp.getEmpName(),emp.getEmpGender(),emp.getDept().getDepId(),emp.getEmpDate());
    }

    @Override
    public int updateInfo(Emp emp) {
        String sql = "UPDATE tb_emp set emp_uname = ?,emp_pwd = ?,emp_name = ?,emp_gender = ?,dep_id = ? where emp_id = ?;";
        return JDBCUtil.executeUpdate(sql,emp.getEmpUname(),emp.getEmpPwd(),emp.getEmpName(),emp.getEmpGender(),emp.getDept().getDepId(),emp.getEmpId());
    }
}