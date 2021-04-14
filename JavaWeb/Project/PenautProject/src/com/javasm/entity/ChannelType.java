package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/14-21:03
 * @Since:jdk1.8
 * @Description:渠道类别级别实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChannelType {
    private Integer id; // 类别id
    private String typeName; // 种类名称
    private Integer parentId; // 父类id
    private String note; // 备注
    private Integer state; // 分类状态 1正常 0删除
    private Date createTime; // 创建时间
}