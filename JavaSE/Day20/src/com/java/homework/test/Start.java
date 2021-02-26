package com.java.homework.test;

import com.java.homework.action.EmpAction;
import com.java.homework.action.impl.EmpActionImpl;
import com.java.homework.demo.Emp;

import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-18:53
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Start {
    Scanner scanner = new Scanner(System.in);
    EmpAction empAction = new EmpActionImpl();

    public void show() {
        List<Emp> list = empAction.findAllEmp();
        System.out.println("id\t\t\t姓名");
        for (Emp emp : list) {
            System.out.println(emp.getId() + "\t\t\t" + emp.getName());
        }
    }

    public void add() {
        System.out.println("请输入员工id:");
        String id = scanner.next();
        System.out.println("请输入员工姓名:");
        String name = scanner.next();
        empAction.addEmp(new Emp(id, name));
    }

    public void delById() {
        System.out.println("请输入要删除员工的id：");
        empAction.deleteEmpById(scanner.next());
    }

    public void update() {
        System.out.println("请输入要修改员工的id：");
empAction.updateEmp(scanner.next());
    }

    public void menu() {
        boolean flag = true;
        while (flag) {
            System.out.println("1.添加 2.修改 3.删除 4.查询 0.退出");
            System.out.println("请输入要进行的操作：");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    add();
                    System.out.println("添加->");
                    break;
                case 2:
                    System.out.println("修改->");
                    update();
                    break;
                case 3:
                    System.out.println("删除->");
                    delById();
                    break;
                case 4:
                    System.out.println("查询->");
                    show();
                    break;
                case 0:
                    System.out.println("退出...");
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}