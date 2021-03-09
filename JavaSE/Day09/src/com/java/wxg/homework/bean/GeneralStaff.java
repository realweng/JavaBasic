package com.java.wxg.homework.bean;

import lombok.*;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-20:12
 * @Since:jdk1.8
 * @Description:作业4普通员工类
 */
@Setter
@Getter
@NoArgsConstructor


public class GeneralStaff extends Staff{
    private double salary; //工资
    private String title;  //职称

    /**
     * 打酱油的方法
     */
    public void daJiangyou(){
        System.out.println("员工打酱油");
    }

    public GeneralStaff(String id, String name, double salary, String title) {
        super(id, name);
        this.salary = salary;
        this.title = title;
    }

    /**
     * 获取普通员工的工资
     * @return
     */
    public double calSalary(){
        System.out.println("员工的工资为"+this.salary);
        return this.salary;
    }
}