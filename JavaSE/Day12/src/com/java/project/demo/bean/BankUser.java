package com.java.project.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/1-15:39
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankUser {
    private String id;
    private String pwd;
    private float money;
}