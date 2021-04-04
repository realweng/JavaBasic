package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/4/2-16:53
 * @Since:jdk1.8
 * @Description:TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    private Integer areaId;
    private String areaName;
    private Integer areaLevel;
    private Integer parentId;

}
