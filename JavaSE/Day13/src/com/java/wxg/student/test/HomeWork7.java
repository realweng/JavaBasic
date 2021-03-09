package com.java.wxg.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/2-20:28
 * @Since:jdk1.8
 * @Description:作业7
 */

import java.util.Scanner;

/**
 * 让用户在控制台不断录入英文字母
 * （每次录入两个字母即可），直到总长度超过6个停止，
 * 然后统计一下一共有几个a？
 */
public class HomeWork7 {
    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        //用户输入
        StringBuilder s1 = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        boolean isFlag = true;
        while (isFlag){
            s1.append(scanner.next());
            if(s1.length()>=6){
                isFlag = false;
            }
        }

        //判断a的个数，通过判断能删除a的次数判断a有多少个
        System.out.println(s1);
        int count = 0;
        while (true){
            try{
                s1.delete(s1.indexOf("a"),s1.indexOf("a")+1);
                count++;
            }catch (StringIndexOutOfBoundsException e){ //捕获到索引越界异常就跳出循环
                break;
            }
        }
        System.out.println(count);
    }
}