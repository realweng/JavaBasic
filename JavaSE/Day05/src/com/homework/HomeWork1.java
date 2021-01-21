package com.homework;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/21-17:33
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork1 {
    public static void main(String[] args) {
        //将以下这个二位数组输出:
        String [][] employees = {
                {"1","段誉","22","3000"},
                {"2","令狐冲","32","18000","15000","2000"},
                {"3","任我行","23","7000"},
                {"4","张三丰","24","7300"},
                {"5","周芷若","28","10000","5000"},
                {"6","赵敏","22","6800"},
                {"7","张无忌","29","10800","5200"},
                {"8","韦小宝","30","19800","15000","2500"},
                {"9","杨过","26","9800","5500"},
                {"10","小龙女","21","6600"},
                {"11","郭靖","25","7100"},
                {"12","黄蓉","27","9600","4800"},
        };

        for (String[] employee : employees) {
            for (String employ : employee) {
                System.out.print(employ+"\t");
            }
            System.out.println();
        }

    }
}