package com.java.wxg.service;

import com.java.wxg.bean.Emp;
import com.java.wxg.bean.vo.ClockInVO;
import com.java.wxg.dao.ClockInDao;
import com.java.wxg.dao.ClockInDaoImpl;

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