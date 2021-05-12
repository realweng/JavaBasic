package com.javasm.dao;

import com.javasm.entity.Dep;
import com.javasm.entity.Emp;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-16:16
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface EmpDao {
    /**
     * 联表查询 通过员工id获取其所在部门信息
     * @param empId
     * @return
     */
    Emp getEmpDep(Integer empId);
}
