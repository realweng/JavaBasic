package com.java.homework.test;

import com.java.homework.bean.JavaTeacher;
import com.java.homework.bean.WebTeacher;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-18:54
 * @Since:jdk1.8
 * @Description:TODO
 */
public class TeacherTest {
    public static void main(String[] args) {
        JavaTeacher t1 = new JavaTeacher();
        t1.setId("1001");
        t1.setName("张三");
        t1.SelfDescription(t1.getCourseName());
        t1.teacherRating("A");

        WebTeacher w1 = new WebTeacher();
        w1.setId("1002");
        w1.setName("李四");
        w1.SelfDescription(w1.getCourseName());
        w1.teacherRating("S");
    }
}