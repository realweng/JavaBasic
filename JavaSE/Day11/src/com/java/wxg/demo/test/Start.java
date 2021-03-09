package com.java.wxg.demo.test;

import com.java.wxg.demo.bean.Grade;
import com.java.wxg.demo.bean.Stu;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-11:36
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@AllArgsConstructor

public class Start {
    private Stu[] stu;
    private Scanner sc;

    /**
     * 初始化
     */
    public Start() {
        sc = new Scanner(System.in);
        stu = new Stu[3];
        init();
    }

    /**
     * 数据初始化
     */
    public void init(){
        Grade grade1[] = new Grade[2];
        grade1[0] = new Grade("数学",90);
        grade1[1] = new Grade("英语",87);
        stu[0] = new Stu("张三",grade1);

        Grade grade2[] = new Grade[2];
        grade2[0] = new Grade("数学",90);
        grade2[1] = new Grade("英语",87);
        stu[1] = new Stu("李四",grade2);

        Grade grade3[] = new Grade[2];
        grade3[0] = new Grade("数学",90);
        grade3[1] = new Grade("英语",87);
        stu[2] = new Stu("王五",grade3);
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {

    }
}