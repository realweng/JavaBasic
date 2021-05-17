package com.javasm.entity;

import com.javasm.constants.DataModelStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/8-10:33
 * @Since:jdk1.8
 * @Description：数据封装
 */
@Data
@AllArgsConstructor
public class DataModel<T> {
    private Integer code;
    private String msg;
    private T data;

    public DataModel() {
        this.code = DataModelStatus.OK.getCode();
        this.msg = DataModelStatus.OK.getMsg();
    }

    public DataModel(T data) {
        this.code = DataModelStatus.OK.getCode();
        this.msg = DataModelStatus.OK.getMsg();
        this.data = data;
    }
}