package com.javasm.service;

import com.javasm.entity.Emp;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-16:24
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface DepService {
    /**
     * 联表查询 通过部门id获取该部门下的所有员工
     * @param depId
     * @return
     */
    List<Emp> getDepEmps(Integer depId);
}
