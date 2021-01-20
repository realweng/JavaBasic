package homework;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/20-19:02
 * @Since:jdk1.8
 * @Description:TODO
 */
public class HomeWork2 {
    public static void main(String[] args) {
        /*
        声明一个字符串的数组，空间为5个。使用循环接收五个学生的姓名。再使用循环输出这五个学生的姓名。
         */
        Scanner scanner = new Scanner(System.in);
        String name[] = new String[5];
        System.out.println("请输入5个学生的姓名：");
        for (int i = 0; i < name.length; i++) {
            name[i] = scanner.next();
        }
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i]+"\t");
        }
    }
}