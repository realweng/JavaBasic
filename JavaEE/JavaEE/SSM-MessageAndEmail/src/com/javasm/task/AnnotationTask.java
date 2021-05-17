package com.javasm.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/14-19:13
 * @Since:jdk1.8
 * @Description:TODO
 */
public class AnnotationTask {
    public AnnotationTask() {
        System.out.println(this + " 被构造了~");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void run(){
        System.out.println(this + " 执行了~");
    }
}