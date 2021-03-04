package com.java.homework.test;

import com.java.homework.bean.Student;
import com.java.homework.dao.StudentDAO;
import com.java.homework.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/4-18:59
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Start {
    private StudentDAO studentDAO;
    private Scanner scanner;
    private Student student;

    public Start() {
        studentDAO = new StudentDAO();
        scanner = new Scanner(System.in);
        student = new Student();
    }

    public void menu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("1.添加 2.删除 3.修改 4.查询所有 5.根据专业查询 0.退出");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("添加-->");
                    addStu();
                    break;
                case 2:
                    System.out.println("删除-->");
                    deleteStu();
                    break;
                case 3:
                    System.out.println("修改-->");
                    updateStu();
                    break;
                case 4:
                    System.out.println("查询所有-->");
                    findAllStu();
                    break;
                case 5:
                    System.out.println("根据专业查询-->");
                    findByMajor();
                    break;
                case 0:
                    System.out.println("退出中...");
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 添加
     */
    public void addStu() {
        System.out.println("请输入学生姓名：");
        student.setStuName(scanner.next());
        System.out.println("请输入学生年龄：");
        student.setStuAge(scanner.nextInt());
        System.out.println("请输入学生专业：");
        student.setStuMajor(scanner.next());
        System.out.println("请输入学生学院：");
        student.setStuDepart(scanner.next());
        student.setStuDate(DateUtil.getNowDate());
        boolean isSuccess = studentDAO.addStu(student);
        if (isSuccess) {
            System.out.println("添加成功！");
        } else
            System.out.println("添加失败");
    }

    /**
     * 修改
     */
    public void updateStu() {
        System.out.println("请输入要修改的学生的id：");
        student.setStuId(scanner.nextInt());
        System.out.println("请输入修改后学生姓名：");
        student.setStuName(scanner.next());
        System.out.println("请输入修改后学生年龄：");
        student.setStuAge(scanner.nextInt());
        System.out.println("请输入修改后学生专业：");
        student.setStuMajor(scanner.next());
        System.out.println("请输入修改后学生学院：");
        student.setStuDepart(scanner.next());
        boolean isSuccess = studentDAO.updateStu(student);
        if (isSuccess) {
            System.out.println("修改成功！");
        } else
            System.out.println("修改失败");
    }

    /**
     * 删除
     */
    public void deleteStu() {
        System.out.println("请输入要删除的学生id：");
        int id = scanner.nextInt();
        boolean isSuccess = studentDAO.delStuById(id);
        if (isSuccess) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    /**
     * 查询所有
     */
    public void findAllStu() {
        List<Student> list = studentDAO.findAllStu();
        if (!list.isEmpty()) {
            show(list);
        }
    }

    /**
     * 根据专业查询学生信息及这个专业的总人数
     */
    public void findByMajor() {
        System.out.println("请输入你要查找的专业：");
        String major = scanner.next();
        List<Student> list = studentDAO.findStuByMajor(major);
        if (list.isEmpty()) {
            System.out.println("该专业没有学生！");
        } else {
            System.out.println(major + "专业共有" + list.size() + "个学生！这些学生的信息如下");
            show(list);
        }
    }

    /**
     * 遍历显示
     * @param list
     */
    private void show(List<Student> list) {
        System.out.println("id\t\t\t\t姓名\t\t\t\t年龄\t\t\t\t专业\t\t\t\t学院\t\t\t\t入学时间");
        for (Student stu : list) {
            System.out.println(stu.getStuId() + "\t\t\t\t" + stu.getStuName() + "\t\t\t\t" + stu.getStuAge() + "\t\t\t\t"
                    + stu.getStuMajor() + "\t\t\t\t" + stu.getStuDepart() + "\t\t\t\t" + DateUtil.dateToString(stu.getStuDate()));
        }
    }
}