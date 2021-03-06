package com.javasm.dao.impl;

import com.javasm.dao.GameDao;
import com.javasm.entity.Game;
import com.javasm.util.JdbcUtil;
import com.javasm.util.PageInfo;
import com.javasm.vo.GameTypeEntity;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

/**
 * @Author：hujun
 * @Version：1.0
 * @Date：2021/4/12-17:07
 * @Since:jdk1.8
 * @Description:TODO
 */
public class GameDaoImpl extends BaseDaoImpl<Game> implements GameDao {

    @Override
    public Game ShowGameById(Integer gameId) {
        String sql = "SELECT * FROM game where gameId = ?";
        return JdbcUtil.getResultById(sql, Game.class, gameId);
    }

    @Override
    public List<GameTypeEntity> show() {
        String sql = "SELECT g.*,gc.typeName from game g,gameclass gc where g.gameClassify = gc.typeid and g.state=1";
        return JdbcUtil.query(sql, GameTypeEntity.class);
    }


}
