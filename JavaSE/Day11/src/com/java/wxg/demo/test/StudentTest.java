package com.java.wxg.demo.test;

import com.java.wxg.demo.action.ManageStuimpl;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-11:30
 * @Since:jdk1.8
 * @Description:TODO
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