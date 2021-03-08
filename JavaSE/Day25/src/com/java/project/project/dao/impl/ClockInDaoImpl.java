package com.java.project.project.dao.impl;

import com.java.project.project.bean.Emp;
import com.java.project.project.bean.vo.ClockInVO;
import com.java.project.project.dao.ClockInDao;
import com.java.project.project.util.DateUtil;
import com.java.project.project.util.JDBCUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-15:25
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClockInDaoImpl implements ClockInDao {
    @Override
    public List<ClockInVO> findClockInByEmpId(Integer empId) {
        List<ClockInVO> list = new ArrayList<>(10);
        String sql = "select a.emp_id,a.emp_name,a.emp_gender,b.clock_time,b.clock_flag from tb_emp a,tb_clockin b where a.emp_id = b.emp_id and a.emp_id = ?";
        list = JDBCUtil.executeQuery(sql, ClockInVO.class, empId);
        return list;
    }

    /**
     * 当前登录员工打卡
     * @param emp
     * @return
     */
    @Override
    public int clickIn(Emp emp){
        String sql = "INSERT into tb_clockin VALUES(null,?,?,?)";
        Date date = new Date();
        int i = DateUtil.checkClockInTime(date);
        if(i>0){
            return JDBCUtil.executeUpdate(sql,emp.getEmpId(),date,1);
        }
        return JDBCUtil.executeUpdate(sql,emp.getEmpId(),date,0);
    }
}