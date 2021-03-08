package com.java.project.homework.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/25-18:53
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp implements Serializable {
    private static final long serialVersionUID = 1524243240891711339L;
    private String id;
    private String name;
}