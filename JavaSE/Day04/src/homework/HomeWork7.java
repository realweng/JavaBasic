package homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-20:15
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork7 {
    public static void main(String[] args) {
        /*
        从键盘接受10个整数保存在数组中，将10个数中最大的与第一个元素交换，
        最小的与最后一个元素交换，其余元素位置不变，输出数组元素的值。
         */
        int n[] = new int[10];
        int n1[] = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入10个整数");
        for (int i = 0; i < n.length; i++) {
            n[i] = scanner.nextInt();
        }
        n1 = Arrays.copyOf(n,10);
        Arrays.sort(n1);
       // System.out.println(Arrays.toString(n1));
        int maxIndex = 0,minIndex = 0;
        for (int i = 0; i < 10; i++) { //获取最大值与最小值的索引
            if(n[i] == n1[0]){
                minIndex = i;
            }
            if (n[i] == n1[9]){
                maxIndex = i;
            }
        }

        for (int i = 0; i < 10; i++) { //开始按照要求交换
            if(i == maxIndex){
                int temp = n[0];
                n[0] = n[maxIndex];
                n[maxIndex] = temp;
            }
            if(i == minIndex){
                int temp = n[n.length-1];
                n[n.length-1] = n[minIndex];
                n[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(n));
    }
}