package homework;

import java.util.Arrays;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-20:36
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork8 {
    public static void main(String[] args) {
        /*
        定义一个数组来存储12个学生的成绩{72,89,65,58,87,91,53,82,71,93,76,68}，
        统计各成绩等级（90分以上为‘A’，80~89分为‘B’，70~79分为‘C’，60~69分为‘D’，60分以下为E）学生人数，
        并将其放入到数组count中，其中：count[0]存E级的人数，count[1]存D级的人数，……，count[4]存A级的人数。
         */
        int grade[] = {72,89,65,58,87,91,53,82,71,93,76,68};
        int count[] = new int[5];
        for (int i = 0; i < grade.length; i++) { //遍历数组
            if(grade[i] >= 90){
                //A级
                count[4]++;
            }
            if(grade[i] >=80 && grade[i] <=89){
                //B
                count[3]++;
            }
            if(grade[i] >=70 && grade[i] <=79){
                //C
                count[2]++;
            }
            if(grade[i] >=60 && grade[i] <= 69){
                //D
                count[1]++;
            }
            if(grade[i] <60 ){
                count[0]++;
            }
        }
        System.out.println(Arrays.toString(count));
    }
}