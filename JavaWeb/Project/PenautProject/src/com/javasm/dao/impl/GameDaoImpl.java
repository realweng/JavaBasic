package com.javasm.dao.impl;

import com.javasm.dao.GameDao;
import com.javasm.entity.Game;
import com.javasm.util.JdbcUtil;
import com.javasm.vo.GameTypeEntity;

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
        String sql = "SELECT * from game g,gameType gt,gameClass gc where g.gameRecommendType=gt.typeid and g.state = gt.typeid and g.gamePlatformType = gt.typeid and g.gamePlatformType=gc.typeid and state=1";
        return JdbcUtil.query(sql, GameTypeEntity.class);
    }
}
