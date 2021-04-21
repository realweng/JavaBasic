package com.javasm.service;

import com.javasm.entity.ChannelType;
import com.javasm.util.PageInfo;
import com.javasm.vo.ChannelTypeEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/15-10:45
 * @Since:jdk1.8
 * @Description:渠道种类业务处理层接口
 */
public interface ChannelTypeService {
    /**
     * 增加渠道种类
     * @param channelType
     * @return
     */
    public boolean addChannelType(ChannelType channelType);

    /**
     * 删除渠道种类
     * @param id
     * @return
     */
    public boolean deleteChannelType(Integer id);

    /**
     * 更改渠道种类
     * @param channelType
     * @return
     */
    public boolean updateChannelType(ChannelType channelType);

    /**
     * 联表查询所有渠道种类
     * @return
     */
    public List<ChannelTypeEntity> findAllChannelTypeEntity();

    /**
     * 分页
     * @param nowPage
     * @param pageNum
     * @return
     */
    PageInfo<ChannelTypeEntity> showTypeByPage(String nowPage, String pageNum);


    /**
     * 统计总数量
     *
     * @param channelTypeEntity
     * @return
     */
    Integer count(ChannelTypeEntity channelTypeEntity);

    /**
     * 通过父级id找子渠道
     * @param parentId
     * @return
     */
    public List<ChannelTypeEntity> findChannelTypeByParentId(Integer parentId) ;
}
