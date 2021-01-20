package homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-18:34
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork1 {
    public static void main(String[] args) {
        /*
        在歌唱比赛中，共有10位评委进行打分，在计算歌手得分时，去掉一个最高分，
        去掉一个最低分，然后剩余的8位评委的分数进行平均，就是该选手的最终得分。
        输入每个评委的评分，求某选手的得分
         */
        double member[] = new double[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入10位评委的评分：");
        for(int i = 0;i < member.length;i++){
            member[i] = sc.nextDouble();
        }
        Arrays.sort(member);
        double sum = 0;
        for(int i = 0;i < member.length;i++){
            if((i == 0) || (i == member.length-1)){
                 member[i]= 0;
            }
            sum += member[i];
        }
        System.out.println("平均成绩"+sum/(member.length-2));
    }
}