package homework;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-19:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork5 {
    public static void main(String[] args) {
        /*
        有一整数数组，{1,3,-1,5,-2}; 将数据复制到新数组中，
        要求逆序输出新数组中的数，同时并将小于0的元素按0存储
         */
        int num1[] = {1,3,-1,5,-2};
        int num2[] = new int[num1.length];
        for (int i = 0; i < num1.length; i++) {
            if(num1[i] < 0){
                num1[i] = 0;
            }
        }
        for (int i = 0; i < num1.length; i++) {
            num2[i] = num1[num1.length-i-1];
        }
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));
    }
}