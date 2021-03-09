package com.java.wxg.homework.action;

import com.java.wxg.homework.demo.Emp;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-18:52
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface EmpAction {
    /**
     * 添加员工
     * @param emp
     */
    public void addEmp(Emp emp);

    /**
     * 通过id删除员工
     * @param id
     */
    public void deleteEmpById(String id);

    /**
     * 修改员工
     * @param id
     */
    public void updateEmp(String id);

    /**
     * 查询所有员工
     * @return
     */
    public  List<Emp> findAllEmp();
}