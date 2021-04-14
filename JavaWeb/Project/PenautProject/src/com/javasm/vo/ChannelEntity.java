package com.javasm.vo;

import com.javasm.entity.Channel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/14-21:04
 * @Since:jdk1.8
 * @Description:渠道管理联表查询实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ChannelEntity extends Channel {
    private String firstType; // 第一级
    private String secondType;// 第二级
}