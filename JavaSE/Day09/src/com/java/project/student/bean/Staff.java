package com.java.project.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-20:10
 * @Since:jdk1.8
 * @Description:作业4员工类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Staff {
    private String id;
    private String name;

    /**
     * 工作的方法
     */
    public void work(){
        System.out.println("员工在工作");
    }

    /**
     * 结算工资的行为
     */
    public double calSalary(){
        return 0;
    }
}