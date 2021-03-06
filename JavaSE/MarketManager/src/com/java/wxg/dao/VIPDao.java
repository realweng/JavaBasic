package com.java.wxg.dao;

import com.java.wxg.bean.VIP;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-23:25
 * @Since:jdk1.8
 * @Description:会员数据层接口
 */
public interface VIPDao {
    /**
     * 添加会员信息
     * @param vip
     * @return
     */
    public int addVIP(VIP vip);

    /**
     * 修改会员信息
     * @param vip
     * @return
     */
    public int updateVIP(VIP vip);

    /**
     * 查询会员信息
     * @return
     */
    public List<VIP> queryVIP();

    /**
     * 删除会员信息
     * @param id
     * @return
     */
    public int deleteVIP(Integer id);

    /**
     * 充值会员余额
     * @param money
     * @return
     */
    public int recharge(Integer id,Double money);

    /**
     * 通过id查找会员
     * @param id
     * @return
     */
    public VIP findVipById(Integer id);

    /**
     * 查找数据库中编号最后的会员信息，以便生成下一个会员卡卡号
     * @return
     */
    public List<VIP> findLastVipId();

    /**
     * 通过卡号找会员
     * @param cardNum
     * @return
     */
    public List<VIP> findVipByCardNum(String cardNum);
}
