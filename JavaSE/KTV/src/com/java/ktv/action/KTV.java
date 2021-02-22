package com.java.ktv.action;

import com.java.ktv.bean.Music;
import com.java.ktv.util.ChineseCharacterUtil;
import com.java.ktv.util.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/5-11:38
 * @Since:jdk1.8
 * @Description:TODO
 */
public class KTV {
    private List<Music> musicList = new ArrayList<>(); //存放KTV已经有的歌
    private List<Music> addList = new ArrayList<>(); //存放KTV点的歌单
    private Music musics[];//歌曲对象的数组
    private Scanner scanner;

    /**
     * 构造方法 初始化数据
     */
    public KTV() {
        scanner = new Scanner(System.in);
        init();
    }

    /**
     * @描述 初始化KTV系统的歌曲
     * @参数
     * @返回值
     * @创建人 wengxingguo
     * @创建时间 2021/2/15
     * @修改人和其它信息
     */
    public void init() {
        musics = new Music[5]; //初始化5首歌曲
        musics[0] = new Music("眉飞色舞", "萧亚轩", "流行", "2:34", DateUtil.getNow(), 100);
        musics[1] = new Music("茉莉花", "宋祖英", "传统", "4:37", DateUtil.getNow(), 111);
        musics[2] = new Music("卖报歌", "贝瓦儿歌", "传统", "3:04", DateUtil.getNow(), 50);
        musics[3] = new Music("素颜", "许嵩", "流行", "3:14", DateUtil.getNow(), 201);
        musics[4] = new Music("天外来物", "薛之谦", "流行", "4:17", DateUtil.getNow(), 177);
        musicList.add(musics[0]);//将初始化的歌曲对象添加到KTV系统歌单列表中
        musicList.add(musics[1]);
        musicList.add(musics[2]);
        musicList.add(musics[3]);
        musicList.add(musics[4]);
    }

    /**
     * @描述 显示歌曲列表
     * @参数 arrayList歌曲列表
     * @返回值
     * @创建人 wengxingguo
     * @创建时间 2021/2/15
     * @修改人和其它信息
     */
    public void showMusicList(List arrayList) {
        System.out.println("序号\t\t歌曲名\t\t\t歌手\t\t\t时长\t\t\t点歌次数");
        if (arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) instanceof Music) {
                    System.out.println((i + 1) + "\t\t\t" + ((Music) arrayList.get(i)).getName() +
                            "\t\t\t" + ((Music) arrayList.get(i)).getSinger() + "\t\t\t"
                            + ((Music) arrayList.get(i)).getTime()+"\t\t\t"+((Music) arrayList.get(i)).getCount());
                }
            }
        }
    }

    /**
     * 通过歌名拼音点歌
     */
    public void addByPinyin() {
        List<Music> list = new ArrayList<>(); //临时存放字母匹配的对象
        System.out.println("************欢迎使用拼音点歌系统**************");
        System.out.println("请输入你要点歌的拼音：");
        String s = scanner.next();
        s = s.toLowerCase();
        System.out.println("序号\t\t歌曲名\t\t\t歌手\t\t\t时长");
        for (int i = 0; i < musicList.size(); i++) {    //找到与输入拼音缩写匹配的歌曲
            String s1 = new String(musicList.get(i).getName());
            String s2 = new String();
            s2 = ChineseCharacterUtil.convertHanzi2Pinyin(s1, false).toLowerCase();//首字母
            String s3 = new String();
            s3 = ChineseCharacterUtil.convertHanzi2Pinyin(s1, true).toLowerCase();//首字母
            if (ChineseCharacterUtil.match(s2, ".*" + s + ".*") || ChineseCharacterUtil.match(s3, ".*" + s + ".*")) {      //通过拼音缩写或全拼匹配
                System.out.println((i + 1) + "\t\t\t" + musicList.get(i).getName() +
                        "\t\t\t" + musicList.get(i).getSinger() + "\t\t\t"
                        + musicList.get(i).getTime());
                list.add(musicList.get(i));
            }
        }
        addByMusicName(list);
    }

    /**
     * 通过歌曲名点歌重写的方法
     */
    public void addByMusicName(List<Music> list) {
        System.out.println("********点歌，输入歌名：***********");
        String musicName = scanner.next();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(musicName)) {
                index = i;
                if (addList.indexOf(list.get(i)) == -1) {
                    addList.add(list.get(i));//将找到的歌曲添加到播放列表中
                    int musicIndex = musicList.indexOf(addList.get(addList.size()-1));
                    //点歌次数+1
                    addList.get(addList.size()-1).setCount(addList.get(addList.size()-1).getCount()+1);
                    musicList.set(musicIndex,addList.get(addList.size()-1));
                } else
                    index = -2;
                break;
            }
        }
        if (index == -1) {
            System.out.println("点歌失败，没有该首歌曲。可反馈给管理员，尽请期待！");
            return;
        } else if (index == -2) {
            System.out.println("该歌曲已经被添加到播放列表中，不需要重复添加！");
        } else {
            System.out.println("点歌成功，已将[" + musicName + "]添加到歌曲列表中！");
        }
        backMenu();
    }

    /**
     * 通过歌星点歌
     */
    public void addBySinger() {
        System.out.println("***********欢迎使用歌手名点歌************");
        List<Music> list = new ArrayList(); //临时存放通过歌手名检索出来的歌曲列表
        System.out.println("请输入歌手名：");
        String singerName = scanner.next();
        System.out.println("序号\t\t歌曲名\t\t\t歌手\t\t\t时长");
        for (int i = 0; i < musicList.size(); i++) {
            if (musicList.get(i).getSinger().equals(singerName)) {
                System.out.println((i + 1) + "\t\t\t" + musicList.get(i).getName() +
                        "\t\t\t" + musicList.get(i).getSinger() + "\t\t\t"
                        + musicList.get(i).getTime());
                list.add(musicList.get(i));
            }
        }
        addByMusicName(list);
    }

    /**
     * 通过分类点歌
     */
    public void addByKind() {
        System.out.println("*********欢迎使用分类点歌*********");
        List<Music> list = new ArrayList(); //临时存放通过歌手名检索出来的歌曲列表
        System.out.println("1.流行歌曲         2.传统歌曲");
        System.out.println("请选择您要添加的歌曲类型：");
        int select = scanner.nextInt();
        if (select == 1) {
            System.out.println("序号\t\t歌曲名\t\t歌手\t\t\t时长");
            for (int i = 0; i < musicList.size(); i++) {
                if (musicList.get(i).getKind().equals("流行")) {
                    System.out.println((i + 1) + "\t\t" + musicList.get(i).getName() +
                            "\t\t" + musicList.get(i).getSinger() + "\t\t"
                            + musicList.get(i).getTime());
                    list.add(musicList.get(i));
                }
            }
        } else if (select == 2) {
            System.out.println("序号\t\t歌曲名\t\t歌手\t\t\t时长");
            for (int i = 0; i < musicList.size(); i++) {
                if (musicList.get(i).getKind().equals("传统")) {
                    System.out.println((i + 1) + "\t\t" + musicList.get(i).getName() +
                            "\t\t" + musicList.get(i).getSinger() + "\t\t"
                            + musicList.get(i).getTime());
                    list.add(musicList.get(i));
                }
            }
        } else {
            System.out.println("您的输入有误");
            backMenu();
        }
        addByMusicName(list);
    }

    /**
     * 好歌排行榜
     * 通过冒泡排序将点歌次数对应的列表从大到小排序
     */
    public void musicRank() {
        for (int i = 0; i < musicList.size() - 1; i++) {
            for (int j = 0; j < musicList.size() - i - 1; j++) {
                if (musicList.get(j).getCount() < musicList.get(j + 1).getCount()) {
                    Music temp = musicList.get(j);
                    musicList.set(j, musicList.get(j + 1));
                    musicList.set(j + 1, temp);
                }
            }
        }
        showMusicList(musicList);
    }

    /**
     * 点歌主菜单
     */
    public void menu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("*************欢迎进入零点KTV点歌台**************");
            System.out.println("1.点歌");
            System.out.println("2.已点歌曲列表");
            System.out.println("0.退出系统");
            System.out.println("请选择：");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    musicMenu(); //显示点歌功能菜单
                    break;
                case 2:
                    playList();
                    break;
                case 0:
                    isFlag = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @描述
     * @参数 点歌台操作界面菜单
     * @返回值
     * @创建人 wengxingguo
     * @创建时间 2021/2/15
     * @修改人和其它信息
     */
    public void musicMenu() {
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("*************点歌台**************");
            System.out.println("1.按拼音点歌");
            System.out.println("2.按歌曲名点歌");
            System.out.println("3.按歌星点歌");
            System.out.println("4.按分类点歌");
            System.out.println("5.好歌排行榜");
            System.out.println("0.返回主菜单");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    addByPinyin();//通过拼音点歌
                    break;
                case 2:
                    addByMusicName(musicList);//通过歌曲名点歌
                    break;
                case 3:
                    addBySinger();//通过歌星点歌
                    break;
                case 4:
                    addByKind();//通过分类点歌
                    break;
                case 5:
                    musicRank();//好歌排行榜
                    break;
                case 0:
                    menu();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 返回菜单
     */
    public void backMenu() {
        System.out.println("********选择返回********");
        System.out.println("1、返回主菜单");
        System.out.println("2、返回点歌台");
        System.out.println("3、返回已点列表");
        System.out.println("请选择：");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                menu();//主菜单
                break;
            case 2:
                musicMenu();//点歌台
                break;
            case 3:
                playList();//对播放列表进行操作
                break;
            default:
                break;
        }
    }

    /**
     * 对播放列表进行操作
     */
    public void playList() {
        System.out.println("**********已点歌曲列表**********");
        showMusicList(addList);//显示添加列表
        System.out.println("*****选择操作******");
        System.out.println("1.歌曲置顶");
        System.out.println("2.歌曲移除");
        System.out.println("3.歌曲前移一位");
        System.out.println("0.返回主菜单");
        System.out.println("请选择：");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                System.out.println("请输入你要置顶的歌曲：");
                String musicName = scanner.next();
                int index = -1;
                for (int i = 0; i < addList.size(); i++) {
                    if(addList.get(i).getName().equals(musicName)){
                        index = i;
                    }
                }
                if (index != -1) {
                    addList.add(0,addList.get(index)); //先加到第一位
                    addList.remove(index+1);//再删除原来的
                    System.out.println(musicName+"置顶成功");
                } else
                    System.out.println("列表中不存在此歌曲");
                break;
            case 2:
                System.out.println("请输入你要移除的歌曲");
                String musicName1 = scanner.next();
                int index1 = -1;
                for (int i = 0; i < addList.size(); i++) {
                    if(addList.get(i).getName().equals(musicName1)){
                        index1 = i;
                    }
                }
                if (index1 != -1)  {
                    addList.remove(index1);//再删除原来的
                    System.out.println(musicName1+"删除成功");
                } else
                    System.out.println("列表中不存在此歌曲");
                break;
            case 3:
                System.out.println("请输入你要前移的歌曲");
                String musicName2 = scanner.next();
                int index2 = -1;
                for (int i = 0; i < addList.size(); i++) {
                    if(addList.get(i).getName().equals(musicName2)){
                        index2 = i;
                    }
                }
                if (index2 != -1 || index2 != 0) {
                    Music temp = addList.get(index2);
                    addList.remove(index2);//删除原来的
                    addList.add(index2-1,temp);//再移动到前一位
                    System.out.println(musicName2+"删除成功");
                } else
                    System.out.println("列表中不存在此歌曲或该歌曲已在第一位不需要前移");
                break;
            case 0:
                menu();//返回主菜单
                break;
            default:
                break;
        }
    }

    /**
     * @描述 程序执行
     * @参数
     * @返回值
     * @创建人 wengxingguo
     * @创建时间 2021/2/15
     * @修改人和其它信息
     */
    public void start() {
        menu();
    }
}