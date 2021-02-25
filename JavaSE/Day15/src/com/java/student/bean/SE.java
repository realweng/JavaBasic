package com.java.student.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-18:44
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SE extends Staff{
    private int exp;    //经验
    public SE(String id, String name, double baseSalary, int exp) {
        super(id, name, baseSalary);
        this.exp = exp;
    }
}