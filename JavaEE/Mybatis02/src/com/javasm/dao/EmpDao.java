package com.javasm.dao;

import com.javasm.entity.Emp;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/27-17:56
 * @Since:jdk1.8
 * @Description:员工数据层接口
 */
public interface EmpDao {
    /**
     * 通过id查询emp
     * @param id
     * @return
     */
    Emp getEmp(Integer id);

    /**
     * 根据员工id获取员工和部门信息
     * @param id
     * @return
     */
    Emp getEmpDep(Integer id);

    /**
     * 条件查询
     * @param emp
     * @return
     */
    List<Emp> findEmp(Emp emp);

    /**
     * 更新emp
     * @param emp
     * @return
     */
    int updateEmp(Emp emp);

    /**
     * 通过id集合找对象集合
     * @param list
     * @return
     */
    List<Emp> findEmpByIds(List<Integer> list);

    List<Emp> findEmpByAny(Emp emp);
}
