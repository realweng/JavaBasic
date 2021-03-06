package com.javasm.entity;

import com.javasm.vo.MenuEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/18-14:05
 * @Since:jdk1.8
 * @Description:菜单实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer mid; //菜单id
    private String menuIcon; //菜单图标
    private String menuName; //菜单名称
    private String menuUrl; //菜单路径
    private Integer parentId; //菜单父级id
    private Integer state; //菜单状态 1表示正常
}