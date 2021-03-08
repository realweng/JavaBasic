package com.java.project.project.dao;

import com.java.project.project.bean.Emp;
import com.java.project.project.util.DateUtil;
import com.java.project.project.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/7-22:43
 * @Since:jdk1.8
 * @Description:TODO
 */
public class EmpDao {
    private Connection con;//连接对象
    private PreparedStatement pstm;//行为对象
    private ResultSet rs;//返回结果对象

    /**
     * 添加要注册用户
     */
    public int addEmp(Emp emp) {
        String sql = "INSERT into tb_emp values(null,?,?,?,?,?,?)";
        return JDBCUtil.executeUpdate(sql, emp.getEmpUname(), emp.getEmpPwd(), emp.getEmpName(), emp.getEmpGender(), emp.getDepId(), DateUtil.dateToString(emp.getEmpDate()));
    }

    /**
     * 通过id查找用户信息
     */
    public Emp findEmpById(Integer id) {
        Emp emp = new Emp();
        String sql = "select * from tb_emp where emp_id = ?";
        List<Object> list = JDBCUtil.executeQuery(sql, emp.getClass(), id);
        if (!list.isEmpty()) {
            emp = (Emp) list.get(0);
        }
        return emp;
    }

    /**
     * 通过用户名查找id，用于注册、登录判断
     */
    public Emp findEmpByUname(String uname) {
        Emp emp = new Emp();
        String sql = "select * from tb_emp where emp_uname = ?";
        List<Object> list = JDBCUtil.executeQuery(sql, emp.getClass(), uname);
        if (!list.isEmpty()) {
            emp = (Emp) list.get(0);
        }
        return emp;
    }

    /**
     * 登录查询，判断用户名密码是否正确
     * @return
     */
    public Integer loginSelect(String uname, String password) {
        Emp emp = findEmpByUname(uname);
        if(emp.getEmpUname()!=null){
            if(password.equals(emp.getEmpPwd())){
                System.out.println("用户名密码正确，登录成功");
            }else{
                System.out.println("密码输入错误");
                return 0;
            }
        }
        return emp.getEmpId(); //返回登录成功的id
    }

    /**
     * 修改信息
     */
    public void updateEmpInfo() {

    }

    /**
     * 添加打卡信息
     */
    public void addClickIn() {

    }

    /**
     * 显示个人所有打卡记录
     */
    public void findAllClick() {

    }

}