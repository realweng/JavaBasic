package com.javasm.dao;

import com.javasm.entity.Game;
import com.javasm.vo.GameTypeEntity;

import java.util.List;

/**
 * @Author：hujun
 * @Version：1.0
 * @Date：2021/4/12-16:57
 * @Since:jdk1.8
 * @Description:TODO
 */
public interface GameDao extends BaseDao<Game> {

    /**
     * 根据ID查找游戏
     *
     * @return
     */
    Game ShowGameById(Integer ganmeId);

    /**
     * 显示所有游戏类型
     *
     * @return
     */
    List<GameTypeEntity> show();

}
