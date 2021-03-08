package com.java.project.project.dao;

import com.java.project.project.bean.Emp;
import com.java.project.project.bean.vo.ClockInVO;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-15:22
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface ClockInDao {
    /**
     * 根据员工的编号查询该员工的考勤记录
     * @param empId
     * @return
     */
    public List<ClockInVO> findClockInByEmpId(Integer empId);
    public int clickIn(Emp emp);
}
