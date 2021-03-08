package com.java.project.demo.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/30-13:33
 * @Since:jdk1.8
 * @Description:猜拳项目电脑类（电脑出拳）
 */
public class Computer {
    public String name;
    /**
     * 电脑出拳
     * @return 返回电脑出拳的结果
     */
    public int guessWhat(){
        int select = (int)(Math.random()*3+1);
        switch (select){
            case 1:
                System.out.println("电脑出拳：剪刀");
                break;
            case 2:
                System.out.println("电脑出拳：石头");
                break;
            case 3:
                System.out.println("电脑出拳：布");
        }
        return select;//返回电脑出拳的结果
    }

    /**
     * 选择哪个机器人进行对战
     * @param select
     */
    public void selectCpt(int select){
        switch (select){
            case 1:
                name = "刘备";
                System.out.println("你选择了刘备对战");
                break;
            case 2:
                name = "孙权";
                System.out.println("你选择了孙权对战");
                break;
            case 3:
                name = "曹操";
                System.out.println("你选择了曹操对战");
                break;
        }
    }
}