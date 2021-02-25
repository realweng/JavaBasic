package com.java.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-18:26
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student implements Comparable<Student> {
    private Integer id;//学号
    private Integer score;//成绩

    @Override
    public int compareTo(Student student) {
        return this.score - student.getScore();
    }
}