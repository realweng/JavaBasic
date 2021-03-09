package com.java.wxg.homework.test;

import com.java.wxg.homework.demo.Music;
import com.java.wxg.homework.demo.MusicPlay;

import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-20:41
 * @Since:jdk1.8
 * @Description:作业3 计算器测试类
 */
public class MusicTest {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入音乐名");
        String musicName = scanner.next();
        System.out.println("请输入播放时长");
        int time = scanner.nextInt();
        System.out.println("请输入歌手名：");
        String singer = scanner.next();
        Music music = new Music();
        music.setMusicName(musicName);
        music.setPlayTime(time);
        music.setSinger(singer);
        MusicPlay play = new MusicPlay();
        play.play(music);
    }
}