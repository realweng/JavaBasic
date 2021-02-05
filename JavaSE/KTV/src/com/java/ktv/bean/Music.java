package com.java.ktv.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/5-11:35
 * @Since:jdk1.8
 * @Description:歌曲的一些属性
 */
@Data
@NoArgsConstructor
public class Music {
    private String name;    //歌曲名
    private String singer;  //歌手
    private String kind;    //所属类别
    private String time;    //时长
    private Date upTime;    //上架时间
    private int count;      //点歌次数

    public Music(String name, String singer, String kind, String time, Date upTime) {
        this.name = name;
        this.singer = singer;
        this.kind = kind;
        this.time = time;
        this.upTime = upTime;
    }
}