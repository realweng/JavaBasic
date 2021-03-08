package com.java.project.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-15:21
 * @Since:jdk1.8
 * @Description:单车公司
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BikeCompany {
    private int bikeCompanyId;// 公司id
    private String bikeCompanyName;// ofo 哈罗 摩拜
    private Bike[] bikes;// 公司持有共享单车
    private int sum;//公司单车总量
    private int count;// 公司单车借出次数
}