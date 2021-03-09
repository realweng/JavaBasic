package com.java.dao;

import com.java.bean.BankUser;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-10:19
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface BankUserDao {
    public void transfer(Integer outUserId,Integer inUserId,Integer money);
    public void addUser(BankUser bankUser);
    public void delUserById(Integer id);
    public void updateUser(BankUser bankUser);

    /**
     * 新增（返回id）
     * @param bankUser
     */
    void addBankUserReturnId(BankUser bankUser);

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    BankUser getBankUserById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<BankUser> findAll();

    /**
     * 统计总条数
     * @return
     */
    int countBankUser();
}
