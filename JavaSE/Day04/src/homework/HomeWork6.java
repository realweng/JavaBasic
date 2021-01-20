package homework;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-19:32
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork6 {
    public static void main(String[] args) {
        /*
        Int[] array = {2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};
        求所有元素和。
        输出所有奇数下标元素。如：array[1]
        输出所有元素中，值为奇数的。
        将所有元素乘二。
        将所有元素加到第一个元素中。
        将奇数位置元素存到B数组中
        偶数元素存到C数组中
        分别逆序输出B数组和C数组
         */
        int[] array = {2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};
        int sum = 0;
        //求所有元素和。
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("所有元素之和为："+sum);

        //输出所有奇数下标元素。如：array[1]
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 !=0){
                System.out.print("所有奇数下标元素: array["+i+"]"+"\t");
                count++;
            }
        }
        System.out.println();

        //输出所有元素中，值为奇数的
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 !=0){
                System.out.print("奇数元素: "+array[i]+"\t");
            }
        }
        System.out.println();

        //将所有元素乘二
//        for (int i = 0; i < array.length; i++) {
//            array[i] *= 2;
//        }
//        System.out.println(Arrays.toString(array));

        //将所有元素加到第一个元素中。
//        for (int i = 1; i < array.length; i++) {
//            array[0] += array[i];
//        }
//        System.out.println(array[0]);

        //将奇数位置元素存到B数组中
        int b[] = new int[count] ;
        for (int i = 0,cnt = 0; i < array.length; i++) {
            if(array[i] % 2 != 0){
                b[cnt] = array[i];
                cnt++;
            }
        }
        System.out.println(Arrays.toString(b));

        //偶数元素存到C数组中
        int c[] = new  int[array.length-count];
        for (int i = 0,cnt = 0; i < array.length; i++) {
            if(array[i] % 2 == 0){
                c[cnt] = array[i];
                cnt++;
            }
        }
        System.out.println(Arrays.toString(c));

        //分别逆序输出B数组和C数组
        for (int i = 0; i < b.length/2; i++) {
            int temp = b[i];
            b[i] = b[b.length - i -1];
            b[b.length - i -1] = temp;
        }

        for (int i = 0; i < c.length/2; i++) {
            int temp = c[i];
            c[i] = c[c.length - i -1];
            c[c.length - i -1] = temp;
        }

        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}