package com.java.wxg.student.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-18:45
 * @Since:jdk1.8
 * @Description:教员类
 */
@Data
@NoArgsConstructor

public class Teacher {
    private String id; //教员编号
    private String name;//教员名称
    private String courseName;//课程名称

    /**
     * 自我介绍方法
     */
    public void SelfDescription(String courseName){
        System.out.println("大家好我是教"+courseName+"的"+name+"老师");
    }

    /**
     * 教师评级
      * @param s 评级的参数
     */
    public void teacherRating(String s){
        System.out.println("教师评级:"+s);
    }

}