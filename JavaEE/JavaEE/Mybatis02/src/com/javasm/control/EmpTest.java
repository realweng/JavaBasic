package com.javasm.control;

import com.javasm.dao.EmpDao;
import com.javasm.entity.Emp;
import com.javasm.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/27-17:59
 * @Since:jdk1.8
 * @Description:测试类
 */
public class EmpTest {
    /**
     * 查询入口
     *
     * @param args
     */
    public static void main(String[] args) {
//        getEmp();
//        getEmpDep();
//        findEmp();
//        updateEmp();
//        findEmpByIds();
        findEmpByAny();
    }

    /**
     * 获取emp
     */
    public static void getEmp() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        Emp emp = empDao.getEmp(101);
        System.out.println(emp);
    }

    /**
     * 通过员工编号获取员工及其对应的部门信息
     */
    public static void getEmpDep() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        Emp empDep = empDao.getEmpDep(101);
        System.out.println(empDep);
        empDep.getDep();
        sqlSession.close();
    }

    public static void findEmp() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
//        emp.setEmpId(101);
        emp.setEmpName("cat");
        List<Emp> empList = empDao.findEmp(emp);
        System.out.println(empList);
        sqlSession.close();
    }

    /**
     * 更改emp数据
     */
    public static void updateEmp() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpId(101);
        emp.setEmpSex("nan");
        emp.setEmpPwd("gggg1");
        int i = empDao.updateEmp(emp);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    /**
     * 通过id集合查找对象集合
     */
    public static void findEmpByIds() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        List<Integer> id = new ArrayList<Integer>() {{
            add(103);
            add(102);
            add(103);
        }};
        List<Emp> empByIds = empDao.findEmpByIds(id);
        System.out.println(empByIds);
        sqlSession.close();
    }

    public static void findEmpByAny() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpId(101);
        emp.setEmpName("c");
//        emp.setEmpSex("女");
        List<Emp> empByAny = empDao.findEmpByAny(emp);
        System.out.println(empByAny);
        sqlSession.close();
    }
}