package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/5-17:26
 * @Since:jdk1.8
 * @Description:用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer id;
    private String userName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}