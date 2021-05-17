package com.javasm.service.impl;

import com.javasm.dao.EmpDao;
import com.javasm.entity.Dep;
import com.javasm.entity.Emp;
import com.javasm.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-16:23
 * @Since:jdk1.8
 * @Description:TODO
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpDao empDao;
    /**
     * 联表查询 通过员工id获取其所在部门信息
     *
     * @param empId
     * @return
     */
    @Override
    public Emp getEmpDep(Integer empId) {
        return empDao.getEmpDep(empId);
    }
}