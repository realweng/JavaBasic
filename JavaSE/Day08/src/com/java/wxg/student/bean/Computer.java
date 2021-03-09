package com.java.wxg.student.bean;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/25-18:29
 * @Since:jdk1.8
 * @Description:电脑类
 */


/**
 * 描述一个电脑类，具有属性：cpu，网卡，显卡，声卡，内存 方法：上网
 */
public class Computer {
    private String cpuName;         //cpu
    private String netCard;         //网卡
    private String graphicsCards;   //显卡
    private String voiceCard;       //声卡
    private String memory;          //内存

    /**
     * 电脑上网的方法
     */
    public void online(){
        System.out.println("电脑上网");
    }

    public Computer(String cpuName, String netCard, String graphicsCards, String voiceCard, String memory) {
        this.cpuName = cpuName;
        this.netCard = netCard;
        this.graphicsCards = graphicsCards;
        this.voiceCard = voiceCard;
        this.memory = memory;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getNetCard() {
        return netCard;
    }

    public void setNetCard(String netCard) {
        this.netCard = netCard;
    }

    public String getGraphicsCards() {
        return graphicsCards;
    }

    public void setGraphicsCards(String graphicsCards) {
        this.graphicsCards = graphicsCards;
    }

    public String getVoiceCard() {
        return voiceCard;
    }

    public void setVoiceCard(String voiceCard) {
        this.voiceCard = voiceCard;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }
}