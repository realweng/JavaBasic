package com.java.student.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-20:13
 * @Since:jdk1.8
 * @Description:作业4经理类
 */
@Data
@NoArgsConstructor

public class Manager extends Staff{
    private double baseSalary;//基本工资
    private double proSalary; //绩效工资
    private double bonus;     //年度分红

    /**
     * 喝茶的方法
     */
    public void drinkTea(){
        System.out.println("经理在喝茶");
    }

    public Manager(String id, String name, double baseSalary, double proSalary, double bonus) {
        super(id, name);
        this.baseSalary = baseSalary;
        this.proSalary = proSalary;
        this.bonus = bonus;
    }

    public double calSalary(){
        System.out.println("经理的工资为"+(baseSalary+proSalary+bonus));
        return baseSalary+proSalary+bonus;
    }
}