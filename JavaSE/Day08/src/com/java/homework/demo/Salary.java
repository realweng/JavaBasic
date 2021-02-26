package com.java.homework.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-19:12
 * @Since:jdk1.8
 * @Description:程序员与产品经理工资计算类
 */
public class Salary {
    /**
     * 产品经理工资计算方法
     * @param pm
     */
    public void salary(PM pm){
        System.out.println("产品经理的工资为："+(pm.getSalary()+pm.getBonus()));
    }

    public void salary(SE se){
        System.out.println("程序员的工资为："+se.getSalary());
    }
}