package com.javasm.control;

import com.javasm.dao.DepDao;
import com.javasm.entity.Dep;
import com.javasm.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/27-17:59
 * @Since:jdk1.8
 * @Description:测试类
 */
public class DepTest {
    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
//        getDep();
        getDepEmps();
    }

    /**
     * 通过id获取一个部门
     */
    public static void getDep(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        DepDao depDao = sqlSession.getMapper(DepDao.class);
        Dep dep = depDao.getDep(1);
        System.out.println(dep);
        sqlSession.close();
    }

    /**
     * 查找部门对应的所有员工
     */
    public static void getDepEmps(){
        SqlSession sqlSession = MyBatisUtil.openSession();
        DepDao depDao = sqlSession.getMapper(DepDao.class);
        Dep dep = depDao.getDepEmps(5);
        System.out.println(dep);
        sqlSession.close();
    }
}