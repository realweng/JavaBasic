package com.java.wxg.constants;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-21:25
 * @Since:jdk1.8
 * @Description:静态常量
 */
public class MarketConstants {
    public static final String DRIVER = "com.mysql.jdbc.Driver";//驱动
    public static final String URL = "jdbc:mysql://localhost:3306/shoppingdb?useSSL=true";//数据库地址
    public static final String SQL_USER = "root", SQL_PASSWORD = "admin";//数据库用户名密码
    public static final String MANAGER_ACCOUNT = "admin", MANAGER_PASSWORD = "admin";//管理员账号密码
    public static final String CASHIER_ACCOUNT = "user", CASHIER_PASSWORD = "user"; //收银员账号密码
    public static final String FLAG_PARENT_ONE = "是", FLAG_PARENT_ZERO = "否";//是否是父级id
    public static final String STATE_ONE = "上架", STATE_TWO = "下架", STATE_THREE = "删除";//商品状态
    public static final String PAY_TYPE_ONE = "现金消费",PAY_TYPE_TWO = "卡内余额";//消费类型
}