package com.java.project.homework.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/23-19:37
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;//编号
    private String name;//名字
    private Integer age;//年龄
    private String gender;//性别
    private String addr;//地址

    public User(String name, Integer age, String gender, String addr) {
        this.id = (int)(Math.random()*900+100);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.addr = addr;
    }
}