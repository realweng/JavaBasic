package com.java.project.student.test;

import com.java.project.student.bean.GeneralStaff;
import com.java.project.student.bean.Manager;
import com.java.project.student.bean.Staff;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-20:14
 * @Since:jdk1.8
 * @Description:作业4的员工测试类
 */
public class StaffTest {
    /**
     * 计算员工工资的方法
     *
     * @param staff 员工
     */
    public void calSalary(Staff staff) {
        double salary = 0;
        if (staff instanceof Manager) { //如果是经理
            Manager manager = (Manager) staff;
            salary = manager.getBaseSalary() + manager.getProSalary() + manager.getBonus();
            manager.drinkTea();
            System.out.println("经理的工资为："+salary);

        } else if (staff instanceof GeneralStaff) { //如果是普通员工
            GeneralStaff generalStaff = (GeneralStaff) staff;
            salary = generalStaff.getSalary();
            generalStaff.daJiangyou();
            System.out.println("普通员工的工资为："+salary);

        }else
            staff.work();
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        StaffTest st = new StaffTest();
        Staff staff1 = new Manager("110","李四",9000,1000,1000);
        Staff staff2 = new GeneralStaff("1010","张三",8000,"高级技工");
        st.calSalary(staff1);
        st.calSalary(staff2);
    }
}