package com.java.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/31-14:20
 * @Since:jdk1.8
 * @Description:finally
 */
public class FinallyTest {

    public void test1(){
        try{
            int a = 10;
            int b = 0;
            System.out.println(a/b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("最终会执行的语句");
        }
    }
    public static void main(String[] args) {
        FinallyTest ft = new FinallyTest();
        ft.test1();
    }
}