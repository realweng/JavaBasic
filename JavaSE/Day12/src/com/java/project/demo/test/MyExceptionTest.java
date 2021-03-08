package com.java.project.demo.test;

import com.java.project.demo.bean.MyException;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-15:17
 * @Since:jdk1.8
 * @Description:TODO
 */
public class MyExceptionTest {
    public void test() throws MyException {
        int num = 10;
        if(num != 100){
            throw new MyException("出现异常",111);
        }
    }
    public static void main(String[] args)  {
        MyExceptionTest me = new MyExceptionTest();
        try{
            me.test();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}