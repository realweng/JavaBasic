package com.java.work.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-13:14
 * @Since:jdk1.8
 * @Description:TODO
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PtEmp extends Emp {
    private float salary;
    private String zhiCheng;

    public PtEmp(int id, String name, float salary, String zhiCheng) {
        super(id, name);
        this.salary = salary;
        this.zhiCheng = zhiCheng;
    }

    public void daJy() {
        System.out.println("打酱油！");
    }

    public float salaryCount() {
        return this.salary;
    }
}
