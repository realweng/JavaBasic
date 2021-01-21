package homework;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-19:11
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork3 {
    public static void main(String[] args) {
        //定义一个数组，录入不同的数字。然后计算3这个数字出现的次数。
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int n = sc.nextInt();
        int num[] = new int[n];
        System.out.println("请输入长度为"+n+"的数组");
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int numCounter = 0;
        for (int i = 0; i < n; i++) {
            if(num[i] == 3){
                numCounter++;
            }
        }
        System.out.println("这个数组出现3的次数为："+numCounter);

    }
}