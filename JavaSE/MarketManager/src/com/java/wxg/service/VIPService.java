package com.java.wxg.service;

import com.java.wxg.bean.VIP;
import com.java.wxg.dao.VIPDao;
import com.java.wxg.dao.impl.VIPDaoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/10-9:35
 * @Since:jdk1.8
 * @Description:会员信息业务处理层
 */
public class VIPService {
    VIPDao vipDao = new VIPDaoImpl();//会员数据层实现的对象
    /**
     * 添加会员信息
     * @param vip
     * @return
     */
    public int addVIP(VIP vip) {
        return vipDao.addVIP(vip);
    }

    /**
     * 修改会员信息
     * @param vip
     * @return
     */
    public int updateVIP(VIP vip) {
        return vipDao.updateVIP(vip);
    }

    /**
     * 查询会员信息
     *
     * @return
     */
    public List<VIP> queryVIP() {
        return vipDao.queryVIP();
    }

    /**
     * 删除会员信息
     *
     * @param id
     * @return
     */
    public int deleteVIP(Integer id) {
        return vipDao.deleteVIP(id);
    }

    /**
     * 充值会员余额
     *
     * @param money
     * @return
     */
    public int recharge(Integer id,Double money) {
        return vipDao.recharge(id,money);
    }

    /**
     * 通过id查找会员
     *
     * @param id
     * @return
     */
    public VIP findVipById(Integer id) {
        return vipDao.findVipById(id);
    }

    /**
     * 获取当前数据库中最后一个会员的会员编号以便生成下一个会员卡卡号
     * @return
     */
    public Integer findLastVipId(){
        List<VIP> list = vipDao.findLastVipId();
        return list.get(0).getId();
    }
}