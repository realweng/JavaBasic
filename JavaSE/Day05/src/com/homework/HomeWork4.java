package com.homework;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/21-18:46
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork4 {
    public static void main(String[] args) {
        /*
        标准答案是：ABDCD，每道题2分，求出每个学生的成绩分别是多少？
        5位同学的答案分别是：小白【ABCCD】、小黑【ABDDC】、小兰【ABDCC】、小绿【ABBBC】、小青【ACCC】
        提示：将正确答案存储到一个一维数组中，将学生的成绩存储到二维数组中。然后进行比较。
         */
        String stuAnswers[][] = {
                {"小白","A","B","C","C","D"},
                {"小黑","A","B","D","D","C"},
                {"小兰","A","B","D","C","C"},
                {"小绿","A","B","B","B","C"},
                {"小青","A","C","C","C",null}
        };

        String answers [] = {"A","B","D","C","D"};

        for (int i = 0; i < stuAnswers.length; i++) {
            int count[] = new int[5]; //标记答案是否正确
            for (int j = 0,k = 1; j < answers.length; j++,k++) {
                if(answers[j].equals(stuAnswers[i][k])){
                    count[i]++;
                }
            }
            System.out.println(stuAnswers[i][0]+"同学的成绩是"+(count[i]*5));

        }

    }
}