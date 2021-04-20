package com.javasm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/15-10:04
 * @Since:jdk1.8
 * @Description:渠道种类联表查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelTypeEntity{
    private Integer id; // 类别id
    private String typeName; // 种类名称
    private Integer parentId; // 父类id
    private String note; // 备注
    private Integer state; // 分类状态 1正常 0删除
    private Date createTime; // 创建时间
    private String parentName;// 渠道种类父类名称
    private List<ChannelTypeEntity> sonList; //子渠道列表
}