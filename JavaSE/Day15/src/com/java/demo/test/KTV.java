package com.java.demo.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/4-15:42
 * @Since:jdk1.8
 * @Description:TODO
 */
public class KTV {
    private Scanner scanner;
    private ArrayList musicList;

    /**
     * 构造器
     */
    public KTV() {
        scanner = new Scanner(System.in);
        musicList = new ArrayList(10);
    }

    /**
     * 添加歌曲
     */
    public void addMusic() {
        System.out.println("请输入要添加歌曲名：");
        String music = scanner.next();
        musicList.add(music);
    }

    /**
     * 显示列表
     */
    public void showList() {
        System.out.println("----------------------------");
        System.out.println("序号\t" + "歌曲");
        System.out.println("----------------------------");
        for (int i = 0; i < musicList.size(); i++) {
            System.out.println((i + 1) + "\t" + musicList.get(i));
            System.out.println("----------------------------");
        }
    }

    /**
     * 删除歌曲
     */

    public void deleteMusic() {
        System.out.println("请输入要删除歌曲名：");
        String music = scanner.next();
        if (musicList.indexOf(music) == -1) {
            System.out.println("当前输入歌曲不存在，删除失败！");
            return;
        }
        musicList.remove(music);
        System.out.println("成功删除“" + music + "”这首歌");
    }

    /**
     * 置顶
     */
    public void toTop() {
        System.out.println("请输入要置顶的歌曲");
        String music = scanner.next();
        if(musicList.indexOf(music)==-1){
            System.out.println("输入的歌曲不存在");
            return;
        }
        musicList.remove(music); //先将当前位置的删除
        musicList.add(0,music); //然后再在第一个位置添加
        System.out.println("“"+music+"”置顶成功");
    }

    /**
     * 上移一位
     */
    public void toUp(){
        System.out.println("请输入要上移的歌曲");
        String music = scanner.next();
        int index = musicList.indexOf(music);
        if(index == -1){
            System.out.println("输入的歌曲不存在");
            return;
        }
        musicList.remove(music); //先删除当前位置的歌曲
        musicList.add(index-1,music); //再将这首歌添加到前一位
    }

    /**
     * 菜单
     */
    public void menu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("1.添加歌曲 2.删除歌曲 3.显示歌曲 4.置顶歌曲 5.上移 6.退出");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    addMusic();
                    break;
                case 2:
                    deleteMusic();
                    break;
                case 3:
                    showList();
                    break;
                case 4:
                    toTop();
                    break;
                case 5:
                    toUp();
                    break;
                case 6:
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 程序的入口
     *
     * @param args
     */
    public static void main(String[] args) {
        KTV ktv = new KTV();
        ktv.menu();
    }
}