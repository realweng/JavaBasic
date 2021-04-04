package com.javasm.util;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/3/12-10:45
 * @Since:jdk1.8
 * @Description:TODO
 */
public class Utils {
    /**
     * 验证字符串是否输入？
     *
     * @param str
     * @return
     */
    public static boolean stringIsEmpty(String str) {
        if (str == null || str.equals("null") || str.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 验证编号是否输入？
     * @param id
     * @return
     */
    public static boolean integerIsEmpty(Integer id){
        if(id == null || id == 0){
            return false;
        }else{
            return true;
        }
    }
}
