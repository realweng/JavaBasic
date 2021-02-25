package com.java.student.util;

import com.java.student.bean.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/2/24-10:47
 * @Since:jdk1.8
 * @Description:TODO
 */
public class GrowthId {
    /**
     * 生成自增id,list中最大的id+1
     *
     * @param list
     * @return
     */
    public static Long growtIdByList(List<User> list) {
        Long id = 0L;
        if (list.isEmpty()) {
            id = 101l;
        } else {
            //获取list中的最大id是多少
            Collections.sort(list, new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    return (int) o1.getId() - o2.getId();
                }
            });
            id = (long)list.get(list.size() - 1).getId() + 1;
        }
        return 0l;
    }
}