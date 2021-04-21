package com.javasm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/21-19:30
 * @Since:jdk1.8
 * @Description:管理员账号实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserEntity {
    private Integer id; //用户编号
    private String userName; //用户名
    private String pwd; //用户密码
    private Integer role; //用户角色
    private Integer state; //账号状态
    private Date createDate; //创建日期
    private Date lastLoginTime; //最近登录日期
    private String roleName;//角色名称
}