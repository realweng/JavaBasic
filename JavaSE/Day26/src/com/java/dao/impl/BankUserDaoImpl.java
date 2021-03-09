package com.java.dao.impl;

import com.java.bean.BankUser;
import com.java.dao.BankUserDao;
import com.java.util.JDBCUtil;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/3/9-10:26
 * @Since:jdk1.8
 * @Description:TODO
 */
public class BankUserDaoImpl implements BankUserDao {
    @Override
    public void transfer(Integer outUserId, Integer inUserId, Integer money) {
        Connection con = JDBCUtil.getCon();
        String sql1 = "update bankUser set userMoney = userMoney - ? where userId = ?;";
        String sql2 = "update bankUser set userMoney = userMoney + ? where userId = ?;";
        PreparedStatement pstm = null;
        if (con != null) {
            try {
                con.setAutoCommit(false);//关闭自动提交
                pstm = con.prepareStatement(sql1);
                pstm.setInt(1, money);
                pstm.setInt(2, outUserId);
                pstm.executeUpdate();
                System.out.println("转成成功");

                pstm = con.prepareStatement(sql2);
                pstm.setInt(1, money);
                pstm.setInt(2, inUserId);
                pstm.executeUpdate();
                System.out.println("转入成功");
                //提交事务
                con.commit();
            } catch (SQLException e) {
                try {
                    System.out.println("转账失败");
                    con.rollback();
                    con.setAutoCommit(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            } finally {
                JDBCUtil.closeCon(con, pstm, null);
            }
        }
    }

    @Override
    public void addUser(BankUser bankUser) {
        String sql = "insert into bankUser values(null,?,?,?,?)";
        Connection connection = JDBCUtil.getCon();
        QueryRunner queryRunner = new QueryRunner();
        try {
            int i = queryRunner.update(connection,sql, bankUser.getUserName(), bankUser.getUserPhone(),bankUser.getUserEmail(),bankUser.getUserMoney());
            if(i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);
        }
    }

    @Override
    public void delUserById(Integer id) {
        String sql = "delete from bankUser where userId = ?";
        //连接
        Connection connetion = JDBCUtil.getCon();

        QueryRunner queryRunner = new QueryRunner();
        try {
            //返回受影响的行数
            int i = queryRunner.update(connetion, sql, id);
            if (i > 0) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //回收资源
        DbUtils.closeQuietly(connetion);
    }

    @Override
    public void updateUser(BankUser bankUser) {
        String sql = "update bankUser set userPhone = ?,userEmail = ? where userId = ?";
        Connection connection = JDBCUtil.getCon();
        QueryRunner queryRunner = new QueryRunner();
        try {
            int i = queryRunner.update(connection,sql, bankUser.getUserPhone(), bankUser.getUserEmail(), bankUser.getUserId());
            if(i>0){
                System.out.println("修改成功");
            }else
                System.out.println("修改失败");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.closeQuietly(connection);
        }
    }

    @Override
    public void addBankUserReturnId(BankUser bankUser) {
        String sql = "insert into bankUser values(null,?,?,?,?)";
        //连接
        Connection connetion = JDBCUtil.getCon();

        QueryRunner queryRunner = new QueryRunner();
        try {
            System.out.println(queryRunner.insert(connetion, sql, new ScalarHandler<Long>(), bankUser.getUserName(),
                    bankUser.getUserPhone(), bankUser.getUserEmail(), bankUser.getUserMoney()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //回收资源
        DbUtils.closeQuietly(connetion);
    }

    @Override
    public BankUser getBankUserById(Integer id) {
        BankUser bankUser = null;
        String sql = "select * from bankUser where userId = ?";
        //连接
        Connection connetion = JDBCUtil.getCon();

        QueryRunner queryRunner = new QueryRunner();
        try {
            bankUser = queryRunner.query(connetion, sql, new BeanHandler<>(BankUser.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //回收资源
        DbUtils.closeQuietly(connetion);
        return bankUser;
    }

    @Override
    public List<BankUser> findAll() {
        List<BankUser> bankUserList = new ArrayList<>(10);
        String sql = "select * from bankUser";
        //连接
        Connection connetion = JDBCUtil.getCon();

        QueryRunner queryRunner = new QueryRunner();
        try {
            bankUserList = queryRunner.query(connetion, sql, new BeanListHandler<>(BankUser.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //回收资源
        DbUtils.closeQuietly(connetion);
        return bankUserList;
    }

    @Override
    public int countBankUser() {
        int count = 0;
        String sql = "select count(*) from bankUser";
        //连接
        Connection connetion = JDBCUtil.getCon();

        QueryRunner queryRunner = new QueryRunner();
        try {
            count = queryRunner.query(connetion, sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //回收资源
        DbUtils.closeQuietly(connetion);
        return count;
    }

}