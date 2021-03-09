package com.java.wxg.homework.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-19:23
 * @Since:jdk1.8
 * @Description:作业3学生与成绩类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stu{
    private String name;//学生姓名
    private Grade[] grades;//成绩
}