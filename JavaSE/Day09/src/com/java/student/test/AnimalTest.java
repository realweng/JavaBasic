package com.java.student.test;

import com.java.student.bean.Animal;
import com.java.student.bean.Fish;
import com.java.student.bean.Snake;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-21:23
 * @Since:jdk1.8
 * @Description:作业5 动物测试类
 */
public class AnimalTest {

    public void test(Animal animal){
        if(animal instanceof Snake){ //如果动物是蛇
            Snake snake = (Snake) animal;
            snake.run();
        }else { //如果动物是鱼
            Fish fish = (Fish) animal;
            fish.swim();
        }
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        AnimalTest at = new AnimalTest();
        Animal fish = new Fish();
        fish.setType("鱼");
        Animal snake = new Snake();
        snake.setType("蛇");
        at.test(snake);
        at.test(fish);
    }
}