package com.java.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/30-13:31
 * @Since:jdk1.8
 * @Description:猜拳项目
 */
public class User {
    public Computer computer;
    /**
     * 人出拳
     * @param select 出拳选择
     */
    public void guessWhat(int select){
        switch (select){
            case 1:
                System.out.println("你出拳：剪刀");
                break;
            case 2:
                System.out.println("你出拳：石头");
                break;
            case 3:
                System.out.println("你出拳：布");
        }
    }


}