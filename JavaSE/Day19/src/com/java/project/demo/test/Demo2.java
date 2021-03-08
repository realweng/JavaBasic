package com.java.project.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-14:31
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo2 {
    /**
     * 泛型方法
     * @param arrays
     * @param <E>
     */
    public <E> void showArray(E []arrays){
        for (E array : arrays) {
            System.out.println(array+"\t");
        }
        System.out.println();
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        String strings[] = {"111","122","3333"};
        demo2.showArray(strings);

        Integer integers[] = {9,7,6,5,4,3,2,1};
        demo2.showArray(integers);
    }
}