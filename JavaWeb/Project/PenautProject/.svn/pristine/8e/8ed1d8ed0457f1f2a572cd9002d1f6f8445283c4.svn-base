package com.javasm.service;

import com.javasm.entity.Channel;
import com.javasm.util.PageInfo;
import com.javasm.vo.ChannelEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/15-21:10
 * @Since:jdk1.8
 * @Description:渠道业务处理层接口
 */
public interface ChannelService {
    /**
     * 查找所有的渠道
     *
     * @return
     */
    public List<ChannelEntity> findAllChannel();

    /**
     * 更改渠道信息
     * @param channel
     * @return
     */
    public boolean updateChannel(Channel channel);

    /**
     * 添加渠道
     * @param channel
     * @return
     */
    public boolean addChannel(Channel channel);

    /**
     * 删除渠道
     * @param id
     * @return
     */
    public boolean deleteChannel(Integer id);

    /**
     * 统计条数
     * @return
     */
    public Integer count();

    /**
     * 分页查询
     * @param channelEntity
     * @param
     * @return
     */
    public PageInfo<ChannelEntity> findChannelByPage(ChannelEntity channelEntity ,String nowPage, String pageNum);
}
