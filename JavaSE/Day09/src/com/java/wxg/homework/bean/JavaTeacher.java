package com.java.wxg.homework.bean;

import lombok.Data;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-18:47
 * @Since:jdk1.8
 * @Description:Java教员类
 */
@Data

public class JavaTeacher extends Teacher{

    public JavaTeacher() {
        setCourseName("Java基础");
    }
}