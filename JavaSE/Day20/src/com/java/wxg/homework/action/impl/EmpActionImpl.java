package com.java.wxg.homework.action.impl;

import com.java.wxg.homework.action.EmpAction;
import com.java.wxg.homework.demo.Emp;
import com.java.wxg.homework.util.SimpleEmpStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-18:51
 * @Since:jdk1.8
 * @Description:TODO
 */
public class EmpActionImpl implements EmpAction {
    //    List<Emp> empList = new ArrayList<>(10);//临时存放员工信息
    File file = new File("emp.txt");//持久化员工数据
    Scanner scanner = new Scanner(System.in);

    /**
     * 添加员工
     *
     * @param emp
     */
    @Override
    public void addEmp(Emp emp) {
        //如果文件不存在需要创建这个文件
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //如果是空文件第一次添加
        if (file.length() <= 0) {
            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, true));//对象输出流
                objectOutputStream.writeObject(emp);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭流
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            //如果里面有内容就追加数据
        } else {
            SimpleEmpStream simpleEmpStream = null;
            try {
                simpleEmpStream = new SimpleEmpStream(new FileOutputStream(file, true));
                simpleEmpStream.writeObject(emp);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭流
                if (simpleEmpStream != null) {
                    try {
                        simpleEmpStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 通过id删除员工
     *
     * @param id
     */
    @Override
    public void deleteEmpById(String id) {
        List<Emp> list = new ArrayList<>(10);
        list = findAllEmp();
        int index = -1;
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("不存在id为" + id + "的员工");
        } else {
            list.remove(index);//在集合中删除这个员工
            reload(list);//更新文件内容
        }
    }


    /**
     * 修改员工
     *
     * @param id
     */
    @Override
    public void updateEmp(String id) {
        List<Emp> list = new ArrayList<>(10);
        list = findAllEmp();
        int index = -1;
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("不存在id为" + id + "员工");
        } else {
            Emp emp = new Emp();
            emp = list.get(index);
            System.out.println("请输入要修改的员工姓名：");
            String name = scanner.next();
            emp.setName(name);
            list.set(index,emp);//将修改后的信息重新装回集合中
            reload(list);//更新文件内容
        }
    }

    /**
     * 查询所有员工
     *
     * @return
     */
    @Override
    public List<Emp> findAllEmp() {
        List<Emp> list = new ArrayList<>(10);
        if (file.length() == 0) {
            System.out.println("空数据");
        } else {
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                while (true) {
                    Emp emp = (Emp) objectInputStream.readObject();
                    list.add(emp);
                }
            } catch (EOFException e) {
                System.out.println("查询完毕");
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
        return list;
    }

    /**
     * 更新文件信息（重写、修改）
     * @param list
     */
    public void reload(List<Emp> list){
        ObjectOutputStream objectOutputStream = null;
        SimpleEmpStream simpleEmpStream = null;
        //再将更新后的集合中的对象写入文件中
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, false));//输出流，覆盖原来的文件内容
            simpleEmpStream = new SimpleEmpStream(new FileOutputStream(file, true));//在第一个后追加,不覆盖前面的文件
            objectOutputStream.writeObject(list.get(0));
            //追加第一个对象后的对象
            for (int i = 1; i < list.size(); i++) {
                simpleEmpStream.writeObject(list.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (simpleEmpStream != null) {
                try {
                    simpleEmpStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}