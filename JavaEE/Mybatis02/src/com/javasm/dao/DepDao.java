package com.javasm.dao;

import com.javasm.entity.Dep;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/27-17:57
 * @Since:jdk1.8
 * @Description:部门数据层接口
 */
public interface DepDao {
    /**
     * 查询dep
     * @param id
     * @return
     */
    Dep getDep(Integer id);

    /**
     * 通过部门id获取该部门信息及该部门的所有员工
     * @param id
     * @return
     */
    Dep getDepEmps(Integer id);
}
