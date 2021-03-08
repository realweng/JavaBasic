package com.java.project;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-19:13
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork7 {
    public static void main(String[] args) {
        /*
        让计算机随机产生10个0到2之间的数 Math.random()*3
        如果产生的是0就输出“生成了一只白猪，我好怕怕”
        如果产生的是1就输出“生成了一只黑猪，我喜欢”
        如果产生的是2就输出“生成了一只红猪，有下酒菜了”
         */
        for(int i = 0;i < 10;i++){
            int n = (int)((Math.random())*3);
            switch (n){
                case 0:
                    System.out.println("生成了一只白猪，我好怕怕");
                    break;
                case 1:
                    System.out.println("生成了一只黑猪，我喜欢");
                    break;
                case 2:
                    System.out.println("生成了一只红猪，有下酒菜了");
                    break;
                default:
                    break;
            }
        }
    }
}