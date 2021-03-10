package com.java.wxg.dao.impl;

import com.java.wxg.bean.VIP;
import com.java.wxg.dao.VIPDao;

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
        return 0;
    }

    /**
     * 修改会员信息
     *
     * @param vip
     * @return
     */
    @Override
    public int updateVIP(VIP vip) {
        return 0;
    }

    /**
     * 查询会员信息
     *
     * @return
     */
    @Override
    public List<VIP> queryVIP() {
        return null;
    }

    /**
     * 删除会员信息
     *
     * @param id
     * @return
     */
    @Override
    public int deleteVIP(Integer id) {
        return 0;
    }

    /**
     * 充值会员余额
     *
     * @param money
     * @return
     */
    @Override
    public int recharge(Double money) {
        return 0;
    }

    /**
     * 通过id查找会员
     *
     * @param id
     * @return
     */
    @Override
    public VIP findVipById(Integer id) {
        return null;
    }
}