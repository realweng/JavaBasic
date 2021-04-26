package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-22:51
 * @Since:jdk1.8
 * @Description:用户建议实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suggestion {
    private Integer sid;
    private Integer uid;
    private String suggestion;
    private String contact;
    private String platform;
    private String os;
}