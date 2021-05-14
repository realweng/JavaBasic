package com.javasm.constants;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-9:47
 * @Since:jdk1.8
 * @Description:请求返回状态
 */
public enum DataModelStatus {
    OK(200,"操作成功!"),
    FAIL(400,"操作失败!"),
    LOGIN_FAIL(401,"用户名或密码错误"),
    LOGIN_FAIL_BAN(402,"用户被封禁"),
    FIND_DEP_EMPS_EMPTY(409,"没有查询结果"),
    FIND_EMP_DEP_EMPTY(410,"没有查询结果"),
    DEL_USER_ERROR(444,"删除失败"),
    ADD_USER_ERROR(10003,"用户添加失败啦!"),
    REGISTER_CODE_ERROR(10004,"验证码错误!"),
    REGISTER_ERROR(10005,"验证码错误!");

    private Integer code;
    private String msg;

    /**
     * 构造方法
     * @param code
     * @param msg
     */
    DataModelStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
