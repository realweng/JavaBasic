package com.javasm.service.impl;

import com.javasm.dao.ChannelDao;
import com.javasm.dao.impl.ChannelDaoImpl;
import com.javasm.entity.Channel;
import com.javasm.service.ChannelService;
import com.javasm.vo.ChannelEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/15-21:16
 * @Since:jdk1.8
 * @Description:渠道业务处理层接口实现类
 */
public class ChannelServiceImpl implements ChannelService {
    private ChannelDao channelDao ;
    /**
     * 构造器 初始化
     */
    public ChannelServiceImpl() {
        channelDao = new ChannelDaoImpl();
    }

    /**
     * 查找所有的渠道
     *
     * @return
     */
    @Override
    public List<ChannelEntity> findAllChannel() {
        return channelDao.findAllChannelEntity();
    }

    /**
     * 更改渠道信息
     *
     * @param channel
     * @return
     */
    @Override
    public boolean updateChannel(Channel channel) {
        return channelDao.update(channel);
    }

    /**
     * 添加渠道
     *
     * @param channel
     * @return
     */
    @Override
    public boolean addChannel(Channel channel) {
        return channelDao.add(channel);
    }

    /**
     * 删除渠道
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteChannel(Integer id) {
        Channel channel = new Channel();
        channel.setId(id);
        return channelDao.delete(channel);
    }
}