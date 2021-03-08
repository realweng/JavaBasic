package com.java.project.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-18:39
 * @Since:jdk1.8
 * @Description:作业2 的人类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    private String id;  //人的id
    private String pwd; //密码
}