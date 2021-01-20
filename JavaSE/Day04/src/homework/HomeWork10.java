package homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-20:49
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork10 {
    public static void main(String[] args) {
        /*
        定义一个长度为10的数组，然后依次的往数组中录入数字。
        但是需要判断如果某个数字已经存在了，则不能录入该数字。
        直到所有的数字都不重复再显示数组中的内容。
         */
        Scanner sc = new Scanner(System.in);
        int num[] = new int[10];
        for(int i = 0; i < 10; i++){
            //System.out.println("请输入第"+(i+1)+"个数");
            if(i==0){
                num[i] = sc.nextInt();
                continue;
            }
            num[i] = sc.nextInt();
            for (int j = 0; j < i; j++) {
               //遍历已经输入的数组值
                if(num[i] == num[j]){
                    System.out.println("重复输入请重新输入：");
                    num[j+1]=0;
                    i--;
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }
}