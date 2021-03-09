package com.java.wxg.homework.util;

import com.java.wxg.homework.bean.Student;
import com.java.wxg.homework.constants.StudentConstants;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/5-10:00
 * @Since:jdk1.8
 * @Description:TODO
 */
public class JDBCUtil {
    /**
     * 连接
     *
     * @return
     */
    public static Connection getCon() {
        Connection con = null;//连接对象
        try {
            Class.forName(StudentConstants.DRIVER);
            con = DriverManager.getConnection(StudentConstants.URL, StudentConstants.USER, StudentConstants.PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭连接
     */
    public static void conClose(Connection con, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 修改数据
     *
     * @param sql
     * @param o
     * @return
     */
    public static int executeUpdate(String sql, Object... o) {
        Connection con = getCon();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int result = 0;
        if (con != null) {
            try {
                pstm = con.prepareStatement(sql);
                if (o.length > 0 && o != null) {
                    for (int i = 0; i < o.length; i++) {
                        pstm.setObject((i + 1), o[i]);
                    }
                    result = pstm.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conClose(con, pstm, rs);
            }
        }
        return result;
    }

    /**
     * 获取最后一个id
     *
     * @param connection
     * @return
     */
    private static int getLastInsertId(Connection connection) {
        int lastInsertId = 0;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select LAST_INSERT_ID()";
        try {
            pstm = connection.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.next()) {
                lastInsertId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastInsertId;
    }

    /**
     * 查询
     *
     * @param sql
     * @param o
     * @return
     */
    public static List<Map> executeQuery(String sql, Object... o) {
        List<Map> list = new ArrayList<>(10);
        Connection con = getCon();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if (con != null) {
            try {
                pstm = con.prepareStatement(sql);
                if (o.length > 0 && o != null) {
                    for (int i = 0; i < o.length; i++) {
                        pstm.setObject((i + 1), o[i]);
                    }
                }
                rs = pstm.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();//获取元数据(整张表)
                int columnCount = metaData.getColumnCount();//获取列数
                while (rs.next()) {
                    Map<String, Object> map = new HashMap<>(16);
                    for (int i = 1; i <= columnCount; i++) { //从第一列到最后一列
                        String columnLabel = metaData.getColumnLabel(i); //获取列名
                        Object objValue = rs.getObject(columnLabel); //获取列对应格子里面的值
                        map.put(columnLabel, objValue);//将rs走到的那一行数据，一列一列添加到map中
                    }
                    list.add(map); //将rs走到的那一行完整数据及附带列名的map添加到list当中
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    /**
     * 查询(反射的方式)
     *
     * @param sql
     * @param o
     * @return
     */
    public static List<Object> executeQuery1(String sql, Class clazz, Object... o) {
        List<Object> list = new ArrayList<>(10);
        Connection con = getCon();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if (con != null) {
            try {
                pstm = con.prepareStatement(sql);
                //设置参数
                if (o.length > 0 && o != null) {
                    for (int i = 0; i < o.length; i++) {
                        pstm.setObject((i + 1), o[i]);
                    }
                }
                //执行查询
                rs = pstm.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();//获取元数据(整张表)
                int columnCount = metaData.getColumnCount();//获取列数
                while (rs.next()) {
                    //创建对象用于接收数据
                    Object object = clazz.newInstance();
                    //循环取rs走到那一行的每一列数据
                    for (int i = 1; i <= columnCount; i++) {
                        //获取第i列的label,数据库中的列从1开始数
                        String lableName = metaData.getColumnLabel(i);
                        //获取方法名字
                        String methodName = ClassUtil.getClassName(lableName);
                        //反射获取第i个格子数据的数据类型
                        Class aClass = ClassUtil.getClass(metaData.getColumnClassName(i));
                        //反射填充通过方法名获取获取方法
                        Method method = clazz.getMethod(methodName, aClass);//set
                        //获取值
                        Object objectValue = rs.getObject(lableName);
                        //将值存入对象
                        method.invoke(object, objectValue);
                    }
                    list.add(object);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        String sql = "SELECT * from tb_student";

//        List<Map> list = executeQuery(sql);
//        for (Map map : list) {//遍历每一行
//            map.forEach((k,v)->{
//                System.out.print(v+"\t");//遍历当前行对应的每一列数据
//            });
//            System.out.println();
//            System.out.println("-------------------------");
        List<Object> list = executeQuery1(sql, Student.class);
        list.forEach(o -> {
            Student student = (Student) o;
            System.out.println(student.getStuId() + "\t" + student.getStuName() + "\t" + student.getStuAge() + "\t" + student.getStuDepart()+"\t"+DateUtil.dateToString(student.getStuDate()));
        });
//        }
    }
}