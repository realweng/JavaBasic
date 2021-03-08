package com.java.project.project.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/8-11:49
 * @Since:jdk1.8
 * @Description:TODO
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClockIn {
    private Integer clockId;
    private Emp emp;
    private Date clockTime;
    private Integer clockFlag;
}