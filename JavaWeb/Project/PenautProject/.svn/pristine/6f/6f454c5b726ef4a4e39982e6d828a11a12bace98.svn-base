package com.javasm.service.impl;

import com.javasm.dao.GameDao;
import com.javasm.dao.impl.GameDaoImpl;
import com.javasm.entity.Game;
import com.javasm.service.GameService;
import com.javasm.util.PageInfo;
import com.javasm.vo.GameTypeEntity;

import java.util.List;

/**
 * @Author：hujun
 * @Version：1.0
 * @Date：2021/4/12-17:29
 * @Since:jdk1.8
 * @Description:TODO
 */
public class GameServiceImpl implements GameService {
    private GameDao gameDao = new GameDaoImpl();
    private Game game = new Game();

    @Override
    public boolean addGame(Game game) {
        return gameDao.add(game);
    }

    @Override
    public boolean deleteGame(Integer id) {
        game.setGameId(id);
        return gameDao.delete(game);
    }

    @Override
    public boolean updateGame(Game game) {
        return gameDao.update(game);
    }

    @Override
    public List<GameTypeEntity> show() {
        return gameDao.show();
    }


    @Override
    public Game ShowGameById(Integer gameId) {
        return gameDao.ShowGameById(gameId);
    }

}
