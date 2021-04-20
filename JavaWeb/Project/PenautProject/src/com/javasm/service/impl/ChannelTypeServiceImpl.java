package com.javasm.service.impl;

import com.javasm.dao.ChannelTypeDao;
import com.javasm.dao.impl.ChannelTypeDaoImpl;
import com.javasm.entity.ChannelType;
import com.javasm.service.ChannelTypeService;
import com.javasm.util.PageInfo;
import com.javasm.vo.ChannelTypeEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/15-10:46
 * @Since:jdk1.8
 * @Description:渠道种类业务处理层接口实现类
 */
public class ChannelTypeServiceImpl implements ChannelTypeService {
    private ChannelTypeDao channelTypeDao ;

    /**
     * 构造方法 初始化数据
     */
    public ChannelTypeServiceImpl() {
        channelTypeDao = new ChannelTypeDaoImpl();
    }

    /**
     * 增加渠道种类
     *
     * @param channelType
     * @return
     */
    @Override
    public boolean addChannelType(ChannelType channelType) {
        return channelTypeDao.add(channelType);
    }

    /**
     * 删除渠道种类
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteChannelType(Integer id) {
        ChannelType channelType = new ChannelType();
        channelType.setId(id);
        return channelTypeDao.delete(channelType);
    }

    /**
     * 更改渠道种类
     *
     * @param channelType
     * @return
     */
    @Override
    public boolean updateChannelType(ChannelType channelType) {
        return channelTypeDao.update(channelType);
    }

    /**
     * 联表查询所有渠道种类
     *
     * @return
     */
    @Override
    public List<ChannelTypeEntity> findAllChannelTypeEntity() {
        return channelTypeDao.findAllTypeEntity();
    }

    /**
     * 通过分页查询所有数据
     * @param nowPage
     * @param pageNum
     * @return
     */
    @Override
    public PageInfo<ChannelTypeEntity> showTypeByPage(String nowPage, String pageNum) {
        Integer count = channelTypeDao.count();
        PageInfo<ChannelTypeEntity> pageInfo = new PageInfo<>(nowPage, pageNum, count);
        List<ChannelTypeEntity> typeList = channelTypeDao.findAllTypeByPage(pageInfo);
        for (ChannelTypeEntity channelTypeEntity : typeList) {
            channelTypeEntity.getCreateTime();
        }
        pageInfo.setData(typeList);
        return pageInfo;
    }


    /**
     * 统计总数量
     *
     * @param channelTypeEntity
     * @return
     */
    @Override
    public Integer count(ChannelTypeEntity channelTypeEntity) {
        return channelTypeDao.count();
    }

}