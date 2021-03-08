package com.java.project.student.test;

import com.java.project.student.bean.ColorPrinters;
import com.java.project.student.bean.MonoPrinters;
import com.java.project.student.bean.Printer;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/26-19:53
 * @Since:jdk1.8
 * @Description:作业3 打印机的测试类
 */
public class PrinterTest {
    /**
     * 判断不同的打印机调用特定的行为
     * @param printer 接收任意的打印机的类型对象
     */
    public void showPrinter(Printer printer){
        if(printer instanceof ColorPrinters){ //如果是彩色打印机
            ColorPrinters colorPrinters = (ColorPrinters) printer;
            colorPrinters.scan();
        }else if(printer instanceof MonoPrinters){//如果是黑白打印机
            MonoPrinters monoPrinters = (MonoPrinters) printer;
            monoPrinters.show();
        }else
            printer.print();
    }

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        PrinterTest pt = new PrinterTest();
        Printer printer = new Printer(); //打印机
        Printer monoPrinters = new MonoPrinters(); //黑白打印机
        Printer colorPrinters = new ColorPrinters();//彩色打印机
        printer.setType("默认");
        monoPrinters.setType("黑白打印机");
        colorPrinters.setType("彩色打印机");
        pt.showPrinter(printer);
        pt.showPrinter(monoPrinters);
        pt.showPrinter(colorPrinters);
    }
}