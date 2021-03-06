package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：hujun
 * @Version：1.0
 * @Date：2021/4/12-16:24
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private Integer gameId; //唯一编码
    private String gameName;//游戏名称
    private String gameTitle;//标题
    private Float gameSize;//大小(M)
    private String gameIcon;//游戏图标
    private String gameDetails;//游戏详情图片
    private String iosUrl;//ios下载地址
    private String androidUrl;//android下载地址
    private Integer gameDownloads=0;//下载量
    private Integer gameRecommendType;//推荐类型
    private Integer state;//状态
    private String gameClassify;//游戏分类
    private Integer gamePlatformType;//平台类型
    private String gameOver;//游戏描述

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gameTitle='" + gameTitle + '\'' +
                ", gameSize=" + gameSize +
                ", gameIcon='" + gameIcon + '\'' +
                ", gameDetails='" + gameDetails + '\'' +
                ", iosUrl='" + iosUrl + '\'' +
                ", androidUrl='" + androidUrl + '\'' +
                ", gameDownloads=" + gameDownloads +
                ", gameRecommendType=" + gameRecommendType +
                ", state=" + state +
                ", gameClassify='" + gameClassify + '\'' +
                ", gamePlatformType=" + gamePlatformType +
                ", gameOver='" + gameOver + '\'' +
                '}';
    }
}
