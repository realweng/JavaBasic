package com.java.homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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