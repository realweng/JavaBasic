package com.java.project.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-19:47
 * @Since:jdk1.8
 * @Description:作业3 打印机类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Printer {
    private String type;

    /**
     * 打印的方法
     */
    public void print(){
        System.out.println(type+"打印机正在打印");
    }
}