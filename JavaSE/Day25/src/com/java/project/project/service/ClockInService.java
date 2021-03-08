package com.java.project.project.service;

import com.java.project.project.bean.Emp;
import com.java.project.project.bean.vo.ClockInVO;
import com.java.project.project.dao.ClockInDao;
import com.java.project.project.dao.impl.ClockInDaoImpl;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-16:20
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ClockInService {
    ClockInDao clockInDao = new ClockInDaoImpl();
    /**
     * 查询打卡记录
     * @param empId
     * @return
     */
    public List<ClockInVO> findClockInByEmpId(Integer empId){
        return clockInDao.findClockInByEmpId(empId);
    }

    /**
     * 执行打卡操作
     * @param emp
     * @return
     */
    public int clickIn(Emp emp){
        return clockInDao.clickIn(emp);
    }
}