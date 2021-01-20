package homework;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-19:06
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork4 {
    public static void main(String[] args) {
        /*
        现在有如下一个数组： int[] oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        要求将以上数组中的0项去掉，将不为0的值存入一个新的数组，生成新的数组为
        Int[] newArr={1,3,4,5,6,6,5,4,7,6,7,5};
         */
        int[] oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
        int zeroCounter = 0;
        for (int i = 0; i < oldArr.length; i++) { //遍历
            if(oldArr[i] == 0){
                zeroCounter++;
            }
        }
        int newArr[] = new int[oldArr.length-zeroCounter];

        for (int i = 0,cnt = 0; i < oldArr.length; i++) {
            if(oldArr[i]!=0){
                newArr[cnt] = oldArr[i];
                cnt++;
            }
        }
        System.out.println(Arrays.toString(newArr));

    }
}