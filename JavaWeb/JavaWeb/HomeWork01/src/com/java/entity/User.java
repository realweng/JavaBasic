package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/4-19:26
 * @Since:jdk1.8
 * @Description:用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Integer id;
    private String name;
    private String password;
}