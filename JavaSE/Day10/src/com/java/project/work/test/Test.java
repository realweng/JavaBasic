package com.java.project.work.test;

import com.java.project.demo.bean.Dept;
import com.java.project.demo.bean.PtEmp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-15:56
 * @Since:jdk1.8
 * @Description:接口的实现类
 */
public class Test implements Department{
    private Dept dept;
    private Scanner scanner;

    /**
     * 构造方法，初始化
     */
    public Test() {
        dept = new Dept();
        scanner = new Scanner(System.in);
    }

    /**
     * 开始菜单
     */
    @Override
    public void start() {
        boolean b = true;
        while (b){
            System.out.println("1、添加新员工 2、显示所有  3、统计支出");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    addEmp();
                    break;
                case 2:
                    showDept();
                    break;
                case 3:
                    countAllSalary();
                    break;
                default:
                    System.out.println("选择错误!退出！");
                    b = false;
                    break;
            }
        }
    }


    @Override
    public void addEmp() {
        //普通员工的对象
        PtEmp newPtEmp = new PtEmp();
        System.out.println("请输入员工编号：");
        newPtEmp.setId(scanner.nextInt());
        System.out.println("请输入员工的姓名：");
        newPtEmp.setName(scanner.next());
        System.out.println("请输入工资：");
        newPtEmp.setSalary(scanner.nextFloat());
        System.out.println("请输入职称：");
        newPtEmp.setZhiCheng(scanner.next());

        //存入dept普通员工的数组？
        //获取数组
        PtEmp[] ptEmps = dept.getPtEmps();
        //将数组扩容
        ptEmps = Arrays.copyOf(ptEmps, ptEmps.length + 1);
        //再将新员工存入到数组
        ptEmps[ptEmps.length - 1] = newPtEmp;

        //重新填入到部门
        dept.setPtEmps(ptEmps);
    }

    @Override
    public void countAllSalary() {
        //总支出
        float sum = 0;
        //加上经理的工资
        sum += dept.getBoss().salaryCount();
        //+普通员工的工资
        PtEmp[] ptEmps = dept.getPtEmps();
        for (PtEmp ptEmp : ptEmps) {
            sum += ptEmp.salaryCount();
        }
        System.out.println(dept.getDeptName() + "的总支出：" + sum);
    }

    /**
     * 显示所有的
     */
    @Override
    public void showDept() {
        //显示名称
        System.out.println("部门的名称：" + dept.getDeptName());
        //显示经理
        System.out.println("*********经理的基本信息***********");
        System.out.println("员工号：" + dept.getBoss().getId() + "\t经理姓名：" + dept.getBoss().getName());
        //显示所有的普通员工
        System.out.println("*********普通员工的信息***********");
        PtEmp[] ptEmps = dept.getPtEmps();
        System.out.println("员工号\t姓名\t职称");
        for (PtEmp ptEmp : ptEmps) {
            System.out.println(ptEmp.getId() + "\t\t" + ptEmp.getName() + "\t\t" + ptEmp.getZhiCheng());
        }
    }
}