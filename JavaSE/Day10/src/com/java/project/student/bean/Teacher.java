package com.java.project.student.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:42
 * @Since:jdk1.8
 * @Description:作业2 教师类
 */
@Data
@NoArgsConstructor

public class Teacher extends Person{
    /**
     * 有参构造器
     * @param id
     * @param pwd
     */
    public Teacher(String id, String pwd) {
        super(id, pwd);
    }
}