package com.java.util;

import com.java.constant.ConstantUtil;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/1/28-17:25
 * @Since:jdk1.8
 * @Description:TODO
 */
public class BikeUtil {
    /**
     * 通过状态值获取状态
     * @return
     */
    public static String getNameByStatus(int status){
        if(status == 0){
            return ConstantUtil.STATUS_ZERO;
        }
        return ConstantUtil.STATUS_ONE;
    }


}