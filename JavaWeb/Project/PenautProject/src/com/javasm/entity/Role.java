package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/18-14:00
 * @Since:jdk1.8
 * @Description:用户角色
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Role {
    private Integer rid; //角色id
    private String roleName; //角色名称
    private Integer state; //角色状态
}