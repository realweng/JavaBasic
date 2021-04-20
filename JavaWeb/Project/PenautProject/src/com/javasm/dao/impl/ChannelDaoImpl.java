package com.javasm.dao.impl;

import com.javasm.dao.ChannelDao;
import com.javasm.entity.Channel;
import com.javasm.util.JdbcUtil;
import com.javasm.util.PageInfo;
import com.javasm.vo.ChannelEntity;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/15-20:14
 * @Since:jdk1.8
 * @Description:渠道数据接口实现类
 */
public class ChannelDaoImpl extends BaseDaoImpl<Channel> implements ChannelDao {

    /**
     * 联表查询所有渠道实体
     *
     * @return
     */
    @Override
    public List<ChannelEntity> findAllChannelEntity() {
        String sql = "SELECT a.typeName,b.typeName as 'parentName',c.*,d.platformName from \n" +
                "channelType a LEFT JOIN channelType b on a.parentId = b. id \n" +
                "RIGHT JOIN channel c on c.typeId = a.id \n" +
                "LEFT JOIN platform d on d.id = c.platform where c.state = 1";
        return JdbcUtil.query(sql, ChannelEntity.class);
    }

    /**
     * 通过分页查询
     *
     * @param channelEntity
     * @param pageInfo
     * @return
     */
    @Override
    public List<ChannelEntity> findAllByPage(ChannelEntity channelEntity, PageInfo<ChannelEntity> pageInfo) {
        StringBuffer sql = new StringBuffer("SELECT a.typeName,b.typeName as 'parentName',c.*,d.platformName from \n" +
                "channelType a LEFT JOIN channelType b on a.parentId = b. id \n" +
                "RIGHT JOIN channel c on c.typeId = a.id \n" +
                "LEFT JOIN platform d on d.id = c.platform where c.state = 1 ");
        if (channelEntity != null) {
            if (channelEntity.getChannelNumber() != null) {
                sql.append("and c.channelNumber like %" + channelEntity.getChannelNumber() + "% ");
            }
            if (channelEntity.getTypeId() != null) {
                sql.append("and c.typeId = "+channelEntity.getTypeId()+" ");
            }
        }
        sql.append(" limit ?,?");
        return JdbcUtil.query(sql.toString(),ChannelEntity.class,pageInfo.getStartIndex(),pageInfo.getPageNum());
    }


}