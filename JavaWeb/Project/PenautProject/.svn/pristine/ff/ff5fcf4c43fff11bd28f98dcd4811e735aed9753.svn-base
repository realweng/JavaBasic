package com.javasm.dao;

import com.javasm.entity.ChannelType;
import com.javasm.util.PageInfo;
import com.javasm.vo.ChannelEntity;
import com.javasm.vo.ChannelTypeEntity;
import com.javasm.vo.MenuEntity;

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

    /**
     * 分页查询
     * @param pageInfo
     * @return
     */
    public List<ChannelTypeEntity> findAllTypeByPage(PageInfo<ChannelTypeEntity> pageInfo);

    /**
     * 通过父级id找子渠道类型
     * @param parentId
     * @return
     */
    public List<ChannelTypeEntity> findChannelTypeByParentId(Integer parentId);

}
