package com.javasm.constants;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/12-22:11
 * @Since:jdk1.8
 * @Description:redis key字段名称
 */
public interface RedisKeyConstants {
    /**
     * user session key字段的前部分 用于拼接成唯一的key
     */
    String USER_SESSION_KEY = "user_session_";
}
