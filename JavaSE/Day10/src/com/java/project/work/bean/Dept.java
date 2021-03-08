package com.java.project.work.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-13:18
 * @Since:jdk1.8
 * @Description:TODO
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    //部门名称
    private String deptName;
    //一个经理
    private Boss boss;
    //多个普通员工
    private PtEmp [] ptEmps;
}
