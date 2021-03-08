package com.java.project.demo.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-14:27
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Start {
    public static void main(String[] args) {
        IntegerDemo<IntegerDemo> integerDemo = new IntegerDemo<>();
        Integer nums[] = {123, 321, 222, 22233, 444};
        integerDemo.showArray(nums);

        Demo<Double> demo = new Demo();
        Double [] doubles = {123.0,23.0};
        demo.showArray(doubles);
    }
}