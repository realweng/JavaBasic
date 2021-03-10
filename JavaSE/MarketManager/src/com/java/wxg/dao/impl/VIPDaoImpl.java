package com.java.wxg.dao.impl;

import com.java.wxg.bean.VIP;
import com.java.wxg.dao.VIPDao;
import com.java.wxg.util.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-23:24
 * @Since:jdk1.8
 * @Description:会员管理数据层实现类
 */
public class VIPDaoImpl implements VIPDao {
    /**
     * 添加会员信息
     *
     * @param vip
     * @return
     */
    @Override
    public int addVIP(VIP vip) {
        int i = 0;
        String sql = "insert into vip values(null,?,?,?,?,?,?,?,null)";
        i = JDBCUtil.update(sql, vip.getCardNumber(), vip.getVipPassword(), vip.getVipName(), vip.getIphone(), vip.getJiFen(), vip.getMoney(), vip.getCreateTime());
        return i;
    }

    /**
     * 修改会员信息
     *
     * @param vip
     * @return
     */
    @Override
    public int updateVIP(VIP vip) {
        int i = 0;
        String sql = "update vip set vipPassword = ?,vipName = ?,iphone = ?,jiFen = ?,updateTime = ? where id = ?";
        i = JDBCUtil.update(sql, vip.getVipPassword(), vip.getVipName(), vip.getIphone(), vip.getJiFen(), vip.getUpdateTime(),vip.getId());
        return i;
    }

    /**
     * 查询会员信息
     *
     * @return
     */
    @Override
    public List<VIP> queryVIP() {
        List<VIP> list = new ArrayList<>(10);
        String sql = "select * from vip";
        list = JDBCUtil.query(sql, VIP.class);
        return list;
    }

    /**
     * 删除会员信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteVIP(Integer id) {
        int i = 0;
        String sql = "delete from vip where id = ?";
        i = JDBCUtil.update(sql, id);
        return i;
    }

    /**
     * 充值会员余额
     *
     * @param money
     * @return
     */
    @Override
    public int recharge(Integer id,Double money) {
        int i = 0;
        String sql = "update vip set money = money + ? where id = ?";
        JDBCUtil.update(sql,money,id);
        return i;
    }

    /**
     * 通过id查找会员
     *
     * @param id
     * @return
     */
    @Override
    public VIP findVipById(Integer id) {
        String sql = "select * from vip where id = ?";
        VIP vip = JDBCUtil.getResultById(sql, VIP.class, id);
        return vip;
    }

    /**
     * 查找数据库中编号最后的会员信息，以便生成下一个会员卡卡号
     *
     * @return
     */
    @Override
    public List<VIP> findLastVipId() {
        List<VIP> list = new ArrayList<>(10);
        String sql = "select * from vip ORDER BY id desc LIMIT 1";
        list = JDBCUtil.query(sql, VIP.class);
        return list;
    }
}