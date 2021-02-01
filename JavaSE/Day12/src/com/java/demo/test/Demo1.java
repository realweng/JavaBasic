package com.java.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-11:33
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Demo1 {
    public static void main(String[] args) {
        try {
            int[] num = {1, 2, 30};
            System.out.println(num[2]);

            String str = "123f";
            int a = Integer.parseInt(str);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组角标越界异常");
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("其他异常");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("代码执行完成");
        }
    }
}