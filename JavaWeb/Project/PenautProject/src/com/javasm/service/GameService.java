package com.javasm.service;

import com.javasm.entity.Game;
import com.javasm.util.PageInfo;
import com.javasm.vo.GameTypeEntity;

import java.util.List;

/**
 * @Author：hujun
 * @Version：1.0
 * @Date：2021/4/12-17:26
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface GameService {
    /**
     * 添加游戏
     *
     * @return
     */
    public boolean addGame(Game game);

    /**
     * 删除游戏
     *
     * @return
     */
    public boolean deleteGame(Integer id);

    /**
     * 修改游戏
     *
     * @return
     */
    public boolean updateGame(Game game);

    /**
     * 显示所有游戏即类型
     * @return
     */
    List<GameTypeEntity> show();

    /**
     * 根据ID查找游戏
     * @return
     */
    public Game ShowGameById(Integer gameId);

}
