package com.java.wxg.student.test;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-16:28
 * @Since:jdk1.8
 * @Description:TODO
 */

import com.java.wxg.student.bean.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 5.创建一个学生类，包含属性：学号、姓名、性别，包含show（）方法用于显示学生的详细信息。
 * 创建测试类，在控制台上显示添加学生信息，要求程序循环运行，并依次提示接收学生类的所有
 * 属性值，保存到学生对象中，再将学生对象保存到集合对象中，并提示“是否继续添加（y/n）：”,
 * 如果选择“y”则继续添加，否则退出循环，并将保存学生数据的集合对象通过序列化保存到“student.dat”文件中。
 * 实现从“student.dat”文件中反序列化保存学生数据的集合对象，并遍历打印输出学生信息。
 */
public class StudentTest {
    private static Scanner scanner;
    private File stuFile;

    public StudentTest() {
        scanner = new Scanner(System.in);
        stuFile = new File("E:\\student.txt");
    }

    /**
     * 添加学生
     */
    public void addStudent() {
        boolean isFlag = true;
        while (isFlag) {
            if (stuFile.length() <= 0) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(stuFile, true));
                    System.out.println("请输入学生信息（id/pwd/name/gender）：");
                    String id = scanner.next();
                    String pwd = scanner.next();
                    String name = scanner.next();
                    String gender = scanner.next();
                    objectOutputStream.writeObject(new Student(id, pwd, name, gender));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                SimpleStudentStream objectOutputStream = null;
                try {
                    objectOutputStream = new SimpleStudentStream(new FileOutputStream(stuFile, true));
                    System.out.println("请输入学生信息（id/pwd/name/gender）：");
                    String id = scanner.next();
                    String pwd = scanner.next();
                    String name = scanner.next();
                    String gender = scanner.next();
                    objectOutputStream.writeObject(new Student(id, pwd, name, gender));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("是否继续添加：y/n");
            String confirm = scanner.next();
            if (confirm.equals("n")) {
                isFlag = false;
            }
        }
    }

    /**
     * 显示学生
     */
    public void showStudent() {
        List<Student> list = new ArrayList<>(10);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(stuFile));
            while (true) {
                Student student = new Student();
                student = (Student) objectInputStream.readObject();
                list.add(student);
                student.show();
            }
        } catch (EOFException e) {
            System.out.println("读取完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 显示学生
     */
    public List<Student> getStudent() {
        List<Student> list = new ArrayList<>(10);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(stuFile));
            while (true) {
                Student student = new Student();
                student = (Student) objectInputStream.readObject();
                list.add(student);
                // student.show();
            }
        } catch (EOFException e) {
            System.out.println("读取完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 登录
     */
    public void login() {
        Student loginStudent = new Student();
        System.out.println("请输入编号：");
        loginStudent.setId(scanner.next());
        List<Student> list = new ArrayList<>(10);
        list = getStudent();
        Student student = new Student();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            student = list.get(i);
            if (loginStudent.getId().equals(student.getId())) {
                index = i;
            }
        }
        student = list.get(index);
        if (index != -1) {
            System.out.println("编号输入正确");
            System.out.println("请输入密码：");
            loginStudent.setPwd(scanner.next());
            if (loginStudent.getId().equals(student.getId()) && loginStudent.getPwd().equals(student.getPwd())) {
                loginStudent = student;
            }
            if(loginStudent.getName()!=null){
                System.out.println("登录成功");
            }else
                System.out.println("登录失败");
        } else
            System.out.println("用户编号不存在");
    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        StudentTest studentTest = new StudentTest();
        System.out.println("1.添加 2.查询 3.登录");
        int select = scanner.nextInt();
        switch (select){
            case 1:
                System.out.println("添加--->");
                studentTest.addStudent();
                break;
            case 2:
                System.out.println("2.查询--->");
                studentTest.showStudent();
                break;
            case 3:
                System.out.println("3.登录--->");
                studentTest.login();
                break;
            default:
                break;
        }
    }
}