package com.javasm.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/1/28-9:41
 * @Since:jdk1.8
 * @Description:TODO
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //姓名
    private String name;
    //一个学生可以有多门成绩
    private Number[] numbers;

}
