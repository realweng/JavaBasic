package com.java.project.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/27-13:12
 * @Since:jdk1.8
 * @Description:TODO
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Boss extends Emp {
    //基本工资
    private float jb;
    //绩效工资
    private float zx;
    //年度分红
    private float fh;

    public Boss(int id, String name, float jb, float zx, float fh) {
        super(id, name);
        this.jb = jb;
        this.zx = zx;
        this.fh = fh;
    }

    public void tea() {
        System.out.println("老板在喝茶！");
    }

    public float salaryCount() {
        return this.jb + this.zx + this.fh;
    }
}
