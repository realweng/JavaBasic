package com.java.project.homework.test;

import com.java.project.homework.demo.Department;
import com.java.project.homework.demo.GeneralStaff;
import com.java.project.homework.demo.Manager;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-20:52
 * @Since:jdk1.8
 * @Description:作业4 第5小题的测试方法
 */
public class DepartmentTest {

    Scanner scanner;
    public DepartmentTest() {
        scanner = new Scanner(System.in);
    }

    /**
     * 展示部门信息的方法
     * @param department 部门对象
     */
    public void show(Department department){
        //展示经理的信息
        System.out.println("id"+department.getManager().getId());
        System.out.println("姓名"+department.getManager().getName());
        System.out.println("基本工资"+department.getManager().getBaseSalary());
        System.out.println("提成"+department.getManager().getProSalary());
        System.out.println("分红"+department.getManager().getBonus());
        System.out.println("-----------------------------------");
        double salary = department.getManager().getBaseSalary()+
                department.getManager().getProSalary()+department.getManager().getBonus();
        //展示员工的信息
        for (int i = 0; i < department.getStaffs().length; i++) {
            System.out.println("该部门第"+(i+1)+"个员工的个人信息为：");
            System.out.println("id"+department.getStaffs()[i].getId());
            System.out.println("姓名"+department.getStaffs()[i].getName());
            System.out.println("薪水"+department.getStaffs()[i].getSalary());
            System.out.println("职称"+department.getStaffs()[i].getTitle());
            System.out.println();
            salary += department.getStaffs()[i].getSalary();
        }
        System.out.println("该部门总的工资支出为"+salary);
    }

    /**
     * 添加新员工的方法
     * @param department 哪个部门添加新员工
     */
    public void addGeneralStaff(Department department){
        int total = department.getStaffs().length;
        System.out.println("请分别输入要添加员工的id name salary title");
        String id = scanner.next();
        String name = scanner.next();
        double salary = scanner.nextDouble();
        String title = scanner.next();
        //需要添加的新员工
        GeneralStaff staff = new GeneralStaff(id,name,salary,title);
        GeneralStaff []generalStaff = department.getStaffs();
        generalStaff = Arrays.copyOf(generalStaff,total+1);
        //添加新员工到数组的最后一位
        generalStaff[generalStaff.length - 1] = staff;
        //将这个员工添加到该部门
        department.setStaffs(generalStaff);
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Department department = new Department();
        Manager m = new Manager("1001","李四",9000,1000,1000);
        GeneralStaff [] generalStaff = new GeneralStaff[3];
        generalStaff[0] = new GeneralStaff("1998","张1",8000,"高级技工");
        generalStaff[1] = new GeneralStaff("1999","张2",6000,"初级技工");
        generalStaff[2] = new GeneralStaff("2001","张3",8000,"高级技工");
        department.setManager(m);
        department.setStaffs(generalStaff);
        DepartmentTest dt = new DepartmentTest();
        dt.show(department);
    }
}