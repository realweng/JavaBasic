package com.java.student.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/22-17:47
 * @Since:jdk1.8
 * @Description:TODO
 */
public class FootTeam {
    private boolean isFlag; //是否已经分组
    private String name;

    public FootTeam(boolean isFlag, String name) {
        this.isFlag = isFlag;
        this.name = name;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}