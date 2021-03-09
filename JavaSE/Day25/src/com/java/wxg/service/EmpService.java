package com.java.wxg.service;

import com.java.wxg.bean.Emp;
import com.java.wxg.dao.EmpDao;
import com.java.wxg.dao.EmpDaoImpl;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-11:47
 * @Since:jdk1.8
 * @Description:TODO
 */
public class EmpService {
    private EmpDao empDao = new EmpDaoImpl();

    /**
     * 员工登录
     * @param empId
     * @param empPwd
     * @return
     */
    public Emp login(Integer empId, String empPwd){
        return empDao.login(empId, empPwd);
    }

    /**
     * 注册
     * @param emp
     * @return
     */
    public int register(Emp emp){
        return empDao.register(emp);
    }

    /**
     * 修改信息
     * @param emp
     * @return
     */
    public int updateInfo(Emp emp) {
        return  empDao.updateInfo(emp);
    }
}