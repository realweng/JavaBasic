package homework;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-20:37
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork9 {
    public static void main(String[] args) {
        /*
        从键盘输入8个整数存放在一个数组中，
        然后将奇数和偶数分别存入到两个不同的数组中，
        并按奇数、偶数交替的顺序输出这两个数组中的所有数据
        （先交替输出，如果奇数个数多，则再输出剩下的奇数，如果偶数个数多，则再输出剩下的偶数）。
        （提示与要求：（1）定义一个数组存储从键盘输入的8个整数，
        先判断这8个整数中奇数和偶数的个数，才能定义存储奇数和偶数的数组的长度；
         */
        Scanner sc = new Scanner(System.in);
        int num[] = new int[8];
        int count1 = 0,count2 = 0;
        for (int i = 0; i < 8; i++) {
            num[i] = sc.nextInt();
            if(num[i] % 2 != 0){
                count1++;
            }else
                count2++;
        }

        int ji[] = new int[count1];
        int ou[] = new int[count2];

        for (int i = 0,j = 0,k =0; i < 8; i++) { //将奇数偶数分数组存储
            if(num[i] % 2 != 0){
                ji[j] = num[i];
                j++;
            }
            if(num[i] % 2 == 0){
                ou[k] = num[i];
                k++;
            }
        }

        if(count1 >= count2){
            for (int i = 0; i < count2; i++) {
                System.out.print(ji[i]+"\t"+ou[i]+"\t");
            }
            for (int i = count2; i < count1; i++) {
                System.out.print(ji[i]+"\t");
            }
        }else {
            for (int i = 0; i < count1; i++) {
                System.out.print(ji[i]+"\t"+ou[i]+"\t");
            }
            for (int i = count1; i < count2; i++) {
                System.out.print(ou[i]+"\t");
            }
        }
    }
}