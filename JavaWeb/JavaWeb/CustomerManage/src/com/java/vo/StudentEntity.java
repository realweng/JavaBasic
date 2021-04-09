package com.java.vo;

import com.java.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/8-20:51
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity extends Student {
    private String className; //班级名称
}