package com.java.demo.test;

import com.java.demo.bean.Circle;
import com.java.demo.bean.Rectangle;
import com.java.demo.bean.Shape;
import com.java.demo.bean.Squares;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-17:29
 * @Since:jdk1.8
 * @Description:继承与多态的理解
 */
public class ShapeTest {

    public void getArea(Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            circle.setR(10);
            circle.setShapeName("圆形");
            circle.area();
        }else if(shape instanceof Rectangle){
            Rectangle rectangle = (Rectangle) shape;
            rectangle.setShapeName("长方形");
            rectangle.setHeight(10);
            rectangle.setWidth(5);
            rectangle.area();
        }else if(shape instanceof Squares){
            Squares squares =(Squares) shape;
            squares.setShapeName("正方形");
            squares.setLength(10);
            squares.area();
        }else
            shape.area();
    }

    public static void main(String[] args) {
        ShapeTest shapeTest = new ShapeTest();

        Shape shape = new Shape();
        shape.setShapeName("这是一个新的图形");
        shape.area();

        Shape circle = new Circle();
        shapeTest.getArea(circle);

        Shape squares = new Squares();
        shapeTest.getArea(squares);

        Shape rectangle =new Rectangle();
        shapeTest.getArea(rectangle);


    }
}