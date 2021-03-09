package com.java.wxg.student.test;

import com.java.wxg.student.bean.Computer;
import com.java.wxg.student.bean.Student;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-18:37
 * @Since:jdk1.8
 * @Description:学生有电脑的测试类
 */

public class StuComputerTest {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Computer computer = new Computer("i7","wifi6","GTX1660Ti","1","1");
        Student student = new Student("张三","123456",'男');
        student.study(computer); //学生有电脑学习
    }
}