package com.java.wxg.homework.demo;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/26-18:31
 * @Since:jdk1.8
 * @Description:缓冲池
 */
public class OrderPool {
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    /**
     * 生产者生产
     */
    public synchronized void produce() {
        //如果缓冲区满了就等待消费者消费
        if (list.size() == 30) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //产生随机的字符串
        StringBuffer stringBuffer = new StringBuffer();
        char chars[] = new char[10];//存放随机产生的字符
        int random = (int) (Math.random() * 9 + 1);//产生1-9的随机数（至少随机生成员工字符）
        for (int i = 0; i < random; i++) {
            //0.产生数字 1.大写英文字母 2.小写英文字母
            int randomSelect = (int) (Math.random() * 3);//随机产生确定产生哪种字符
            int random0 = (int) (Math.random() * 10 + 48);//产生数字
            int random1 = (int) (Math.random() * 26 + 65);//产生大写英文字符
            int random2 = (int) (Math.random() * 26 + 97);//产生小写英文字符
            switch (randomSelect) {
                case 0:
                    chars[i] = (char) random0;
                    break;
                case 1:
                    chars[i] = (char) random1;
                    break;
                case 2:
                    chars[i] = (char) random2;
                    break;
            }
            stringBuffer.append(chars[i]);//拼接字符串
        }
        list.add(new String(stringBuffer));//生产者生产的字符串
        if (list.size() != 0) {
            System.out.println(Thread.currentThread().getName() + "正在生产1个字符串：" + list.get(list.size() - 1) +
                    " 共有" + list.size() + "个字符串待消费");
        }
        //0.5-1.5s后再生产
        int randomTime = (int) (Math.random() * 1001 + 500);
        try {
            Thread.sleep(randomTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notifyAll();//生产完成提示消费者去消费
    }

    /**
     * 消费者消费
     */
    public synchronized void consumer() {
        if (list.size() == 0) {
            //缓冲区为空，需要等生产者生产后再消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //消费者消费缓冲区的第一个元素
        list.remove(0);
        if (list.size() != 0) {
            System.out.println(Thread.currentThread().getName() + "正在消费字符串：" +
                    list.get(0) + " 还有" + (list.size()) + "个待消费");
        }

        int randomTime = (int) (Math.random() * 1001 + 2000);//2000-3000ms
        try {
            Thread.sleep(randomTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //消费完毕提示生产者生产
        this.notifyAll();
    }
}