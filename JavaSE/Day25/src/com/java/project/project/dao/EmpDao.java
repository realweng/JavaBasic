package com.java.project.project.dao;

import com.java.project.project.bean.Emp;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-12:00
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface EmpDao {
    /**
     * 员工登录
     * @param empId
     * @param empPwd
     * @return
     */
    public Emp login(Integer empId, String empPwd);
    public int register(Emp emp);
    public int updateInfo(Emp emp);
}