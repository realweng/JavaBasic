package com.java.student.test;

import com.java.student.bean.PM;
import com.java.student.bean.SE;
import com.java.student.bean.Salary;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-18:57
 * @Since:jdk1.8
 * @Description:产品经理和程序员的测试类
 */
public class PmTest {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        SE se = new SE("0112","张三",'男',18000,100);
        PM pm = new PM("0001","李四",'男',25000,"rich",10000);
        Salary salary = new Salary();
        salary.salary(se);
        salary.salary(pm);
    }
}