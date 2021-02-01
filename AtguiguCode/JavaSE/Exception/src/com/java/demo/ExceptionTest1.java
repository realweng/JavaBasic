package com.java.demo;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/31-14:05
 * @Since:jdk1.8
 * @Description:try-catch的使用
 */
public class ExceptionTest1 {
    public void test1(){
        try{
            String str = "123";
            str = "abc";
            int num = Integer.parseInt(str);
        }catch (NumberFormatException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("出现数值转换异常");
        }
    }

    public static void main(String[] args) {
        ExceptionTest1 t1 = new ExceptionTest1();
        t1.test1();
    }
}