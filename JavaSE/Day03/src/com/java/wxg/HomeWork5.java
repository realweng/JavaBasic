package com.java.wxg;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/18-18:49
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork5 {
    public static void main(String[] args) {
        /*
        猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个。
        以后每天早上都吃了前一天剩下的一半零一个。到第十天早上想再吃时，见只剩一个桃子了。
        求第一天共摘了多少?
         */
        int n = 1; //桃子的总数目
        for(int i = 1;i < 10;i++){
            n = 2*(n+1);
        }
        System.out.println(n);

    }
}