package com.java.project.bookstore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/21-21:39
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
    private String uid;//会员id
    private Integer age;//会员年龄
    private Integer cnt;//会员积分
}