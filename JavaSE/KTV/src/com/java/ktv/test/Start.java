package com.java.ktv.test;

import com.java.ktv.bean.Music;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/5-11:38
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Start {
    private List<Music> musicList = new ArrayList<>(); //存放KTV已经有的歌
    private List<Music> addList = new ArrayList<>(); //存放KTV点的歌单

    /**
     * 构造方法 初始化数据
     */
    public Start() {
        Music music1 = new Music();
    }
}