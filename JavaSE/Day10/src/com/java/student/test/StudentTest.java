package com.java.student.test;

import com.java.student.bean.ManageStuimpl;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-19:29
 * @Since:jdk1.8
 * @Description:作业3 测试类
 */
public class StudentTest {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        ManageStuimpl manageStuimpl = new ManageStuimpl(); //创建实现类的一个对象
        manageStuimpl.showAll();//展示所有学生的成绩
        manageStuimpl.calGrade("张三"); //计算张三及格的科目数与总成绩
    }
}