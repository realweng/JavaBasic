package com.java.homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-19:39
 * @Since:jdk1.8
 * @Description:作业3学生类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private int id;     //学号
    private String name;//姓名
    private int age;    //年龄

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        if(student.id == this.id){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}