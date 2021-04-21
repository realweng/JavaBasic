package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/14-21:02
 * @Since:jdk1.8
 * @Description:渠道管理实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channel {
    private Integer id; // 渠道id
    private Integer typeId; // 渠道种类id
    private String channelNumber; // 渠道号
    private String channelPath; // 渠道下载地址
    private String productName; // 产品名称
    private String showName; // 显示名称
    private String area; // 地区
    private Integer platform; // 渠道平台 0: all,1: ios,3: android
    private Date createTime; // 创建时间
    private String note;//备注
    private Integer state; // 渠道状态 1正常 0下架 默认为1 删除时改为0
}