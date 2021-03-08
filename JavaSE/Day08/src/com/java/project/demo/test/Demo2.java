package com.java.project.demo.test;

import com.java.project.demo.bean.Animal;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-10:47
 * @Since:jdk1.8
 * @Description:T
 */
public class Demo2 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.name = "cat";
        animal.color = "黄色";
        animal.kind = "猫";
        animal.hobbies("睡觉");
        System.out.println("名字："+animal.name+" 颜色"+animal.color+" 类别："+animal.kind);
    }
}