package com.java.homework.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-20:31
 * @Since:jdk1.8
 * @Description:作业7音乐类
 */
public class Music {
    private String musicName;
    private int playTime;
    private String singer;

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}