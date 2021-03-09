package com.java.wxg.demo.action;

import com.java.wxg.demo.action.impl.ManageStudent;
import com.java.wxg.demo.bean.Grade;
import com.java.wxg.demo.bean.Stu;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-19:35
 * @Since:jdk1.8
 * @Description:作业3 学生成绩管理的实现类
 */
public class ManageStuimpl implements ManageStudent {
    private Stu[] stu;
    private Scanner sc;
    /**
     * 构造方法 初始化
     */
    public ManageStuimpl() {
        sc = new Scanner(System.in);
        stu = new Stu[3];
        init();
    }

    /**
     * 数据初始化
     */
    public void init(){
        Grade grade1[] = new Grade[2];
        grade1[0] = new Grade("数学",90);
        grade1[1] = new Grade("英语",87);
        stu[0] = new Stu("张三",grade1);

        Grade grade2[] = new Grade[2];
        grade2[0] = new Grade("数学",90);
        grade2[1] = new Grade("英语",87);
        stu[1] = new Stu("李四",grade2);

        Grade grade3[] = new Grade[2];
        grade3[0] = new Grade("数学",90);
        grade3[1] = new Grade("英语",87);
        stu[2] = new Stu("王五",grade3);
    }

    /**
     * 展示某一个学生的成绩
     * @param name 学生姓名当做参数
     */
    @Override
    public Grade[] showGrade(String name) {
        for (int i = 0; i < stu.length; i++) {
            if(stu[i].getName().equals(name)){ //找到对应的学生
                return stu[i].getGrades();
            }
        }
        return null;
    }

    /**
     * 计算几个的科目数及其总分
     * @param name
     */
    @Override
    public void calGrade(String name) {
       int count = 0, sum = 0;
        if(showGrade(name)!=null){
            System.out.println("找到了该学生");
            for (Grade grade : showGrade(name)) {
                sum += grade.getGrade();
                if(grade.getGrade() >= 60){
                    count++;
                }
            }
            System.out.println(name+"同学及格了"+count+"门科目，"+"总成绩为"+sum);
       }else
            System.out.println("该学生不存在！");
    }

    /**
     * 显示所有学生的成绩
     */
    @Override
    public void showAll() {
        for (Stu stu1 : stu) {
            System.out.println(stu1.getName()+"同学的成绩为：");
            for (Grade grade : stu1.getGrades()) {
                System.out.println(grade.getSubject()+":"+grade.getGrade());
            }
        }
    }
}