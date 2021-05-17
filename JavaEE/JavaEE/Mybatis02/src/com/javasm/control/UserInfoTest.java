package com.javasm.control;

import com.javasm.dao.UserInfoDao;
import com.javasm.entity.UserInfo;
import com.javasm.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/27-16:38
 * @Since:jdk1.8
 * @Description:测试类
 */
public class UserInfoTest {
    public static void main(String[] args) {
//        getUserByMapper();
//        addUser();
//        updateUser();
        deleteUser();
    }

    /**
     * 添加用户
     */
    public static void addUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserInfoDao userInfoDao = sqlSession.getMapper(UserInfoDao.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("lisi");
        userInfo.setUserSalary(15000f);
        int i = userInfoDao.addUser(userInfo);
        // 提交事务
        sqlSession.commit();
        //获取刚刚新增用户的主键id
        System.out.println(userInfo.getUserId());
        sqlSession.close();
    }

    /**
     * 更新用户信息
     */
    public static void updateUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserInfoDao userInfoDao = sqlSession.getMapper(UserInfoDao.class);
        UserInfo userInfo = new UserInfo(7,"liwu",18000f);
        int i = userInfoDao.updateUser(userInfo);
        // 提交事务
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    /**
     * 删除用户
     */
    public static void deleteUser(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserInfoDao userInfoDao = sqlSession.getMapper(UserInfoDao.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(8);
        int i = userInfoDao.deleteUser(userInfo);
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
        System.out.println(i);
    }

    /**
     * 通过xml配置查询
     */
    public static void getUserForXml() {
        // 获取SqlSession
        SqlSession sqlSession = MyBatisUtil.openSession();
        Object user = sqlSession.selectOne("UserInfo.getUser", 1);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 通过mapper配置查询
     */
    public static void getUserByMapper() {
        // 获取SqlSession
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserInfoDao userInfoDao = sqlSession.getMapper(UserInfoDao.class);
        UserInfo user = userInfoDao.getUser(3);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 查询所有
     */
    public static void findAllUser() {
        // 获取SqlSession
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserInfoDao userInfoDao = sqlSession.getMapper(UserInfoDao.class);
        List<UserInfo> userInfoList = userInfoDao.findAllUserInfo();
        System.out.println(userInfoList);
        sqlSession.close();
    }

    /**
     * 多条件查询得到多个结果
     * 按照传入对象查询
     */
    public static void findUserByObject() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserInfoDao userInfoDao = sqlSession.getMapper(UserInfoDao.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("李四");
        userInfo.setUserSalary(12700f);
        List<UserInfo> all = userInfoDao.findAll(userInfo);
        System.out.println(all);
        sqlSession.close();
    }

    /**
     * 多条件查询得到多个结果
     * 按照传入map查询
     */
    public static void findUserByMap() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserInfoDao userInfoDao = sqlSession.getMapper(UserInfoDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "李四");
        map.put("userSalary", 12700f);
        List<UserInfo> all = userInfoDao.findAllByMap(map);
        System.out.println(all);
        sqlSession.close();
    }

    /**
     * 通过参数直接查询（dao的参数要加注解）
     */
    public static void findAllByParams(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        UserInfoDao userInfoDao = sqlSession.getMapper(UserInfoDao.class);
        List<UserInfo> all = userInfoDao.findAll("李四", 12700f);
        System.out.println(all);
        sqlSession.close();
    }

    /**
     * 反射
     */
    public static void reflect() {
        try {
            Class<?> aClass = Class.forName("com.javasm.entity.UserInfo");
            // 构造方法
            Constructor<?> constructor = aClass.getConstructor(Integer.class,String.class,Float.class);
            Constructor<?> constructor2 = aClass.getConstructor();
            System.out.println(constructor);
            System.out.println(constructor2);

            // 创建对象
            Object tom = constructor.newInstance(5, "tom", 15f);
            System.out.println(tom);
            Object o = constructor2.newInstance();
            System.out.println(o);

            // 获取属性 私有属性用getDeclaredField方法
            Field userName = aClass.getDeclaredField("userName");
            System.out.println(userName);

            // 获取方法
            Method getUserId = aClass.getMethod("getUserId");
            System.out.println(getUserId);

            Method setUserName = aClass.getMethod("setUserName", String.class);
            // (对象，参数)
            setUserName.invoke(tom,"张三");
            System.out.println(tom);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}