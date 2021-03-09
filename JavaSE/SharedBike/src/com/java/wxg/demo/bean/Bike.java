package com.java.wxg.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-15:21
 * @Since:jdk1.8
 * @Description:单车类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    private int bid;// 单车编号
    private String bname;// 单车名称-->ofo 哈罗 摩拜
    private int status;// 单车状态--> 0 已借出 1 可借状态
    private String borrowTime;// 单车借出时间
    private String returnTime;// 单车归还时间
}