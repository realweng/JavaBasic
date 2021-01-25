package com.java.homework.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-20:33
 * @Since:jdk1.8
 * @Description:7.音乐播放器类
 */
public class MusicPlay {
    private String playName;

    /**
     *播放音乐的方法
     */
    public void play(Music music){
        System.out.println("正在播放："+music.getMusicName());
        System.out.println("歌手："+music.getSinger()+"歌唱");
        System.out.println("剩余播放时间"+music.getPlayTime());
    }
}