package com.javasm.dao;

import com.javasm.entity.ChannelType;
import com.javasm.util.PageInfo;
import com.javasm.vo.ChannelTypeEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/14-21:27
 * @Since:jdk1.8
 * @Description:渠道种类数据层接口
 */
public interface ChannelTypeDao extends BaseDao<ChannelType>{
    /**
     * 联表查询所有渠道种类实体
     * @return
     */
    public List<ChannelTypeEntity> findAllTypeEntity();

    public List<ChannelTypeEntity> findAllTypeByPage(PageInfo<ChannelTypeEntity> pageInfo);
}
