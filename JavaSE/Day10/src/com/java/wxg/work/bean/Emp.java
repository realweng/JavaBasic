package com.java.wxg.work.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-13:11
 * @Since:jdk1.8
 * @Description:TODO
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private int id;
    private String name;

    public void working(){
        System.out.println("具有工作的行为！");
    }

    public float salaryCount(){
        System.out.println("工资计算");
        return 0;
    }
}
