package com.java.wxg.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-16:15
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClockInVO {
    private Integer empId;
    private String empName;
    private String empGender;
    private Date clockTime;
    private Integer clockFlag;
}