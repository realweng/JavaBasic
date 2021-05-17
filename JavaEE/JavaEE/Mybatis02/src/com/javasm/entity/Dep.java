package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/27-17:40
 * @Since:jdk1.8
 * @Description:部门实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dep {
    /**
     * 部门id
     */
    private Integer depId;
    /**
     * 部门名称
     */
    private String depName;
    /**
     * 该部门所对应的员工
     */
    private List<Emp> empList;
}