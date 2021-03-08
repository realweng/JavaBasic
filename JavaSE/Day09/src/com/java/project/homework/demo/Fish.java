package com.java.project.homework.demo;

import lombok.Data;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-21:20
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data

public class Fish extends Animal{
    /**
     * 鱼游泳
     */
    public void swim(){
        System.out.println("鱼在水里游！");
    }
}