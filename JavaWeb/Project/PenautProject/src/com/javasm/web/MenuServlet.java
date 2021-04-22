package com.javasm.web;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.javasm.entity.Menu;
import com.javasm.service.MenuService;
import com.javasm.service.impl.MenuServiceImpl;
import com.javasm.util.ConvertUtils;
import com.javasm.util.PageInfo;
import com.javasm.vo.MenuEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/22-10:13
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/menu.do")
public class MenuServlet extends BaseServlet<Menu>{
    private MenuService menuService;
    public MenuServlet() {
        menuService = new MenuServiceImpl();
    }

    /**
     * 分页查询所有的菜单信息
     * @param request
     * @param response
     * @return
     */
    public String showAllMenu(HttpServletRequest request, HttpServletResponse response){
        String message = "";
        // 获取页面信息
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");
        PageInfo<MenuEntity> pageInfo = menuService.findAllMenuEntityByPage(nowPage,pageNum);
        message ="a:"+ JSONObject.toJSONString(pageInfo, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat);
        return message;
    }

    /**
     * 删除菜单
     * @param request
     * @param response
     * @return
     */
    public String deleteMenu(HttpServletRequest request, HttpServletResponse response){
        String message = "";
        String midStr = request.getParameter("id");
        Integer mid = ConvertUtils.StringConvertInteger(midStr);
        Menu menu = new Menu();
        menu = menuService.findMenuById(mid);
        if(menu.getMenuName().equals("权限管理")){
            message = "a:{message:'删除失败，权限管理菜单不可删除'}";
        }else if(menu.getMenuName().equals("菜单管理")){
            message = "a:{message:'删除失败，菜单管理菜单不可删除'}";
        }else {
            boolean flag = menuService.deleteMenu(mid);
            message = flag ? "a:{message:'删除成功'}":"a:{message:'删除失败'}";
        }
        return message;
    }

    /**
     * 查找所有父级菜单
     * @param request
     * @param response
     * @return
     */
    public String findAllParent(HttpServletRequest request, HttpServletResponse response){
        String message = "";
        List<Menu> menuList = menuService.findAllParent();
        message = message ="a:"+ JSONObject.toJSONString(menuList, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat);
        return message;
    }

    /**
     * 添加菜单
     * @param request
     * @param response
     * @return
     */
    public String addMenu(HttpServletRequest request, HttpServletResponse response){
        String message ="";
        // 获取数据
        String menuName = request.getParameter("menuName");
        String menuIcon = request.getParameter("menuIcon");
        String parentIdStr = request.getParameter("parentId");
        String menuUrl = request.getParameter("menuUrl");
        String stateStr = request.getParameter("state");

        // 类型转换
        Integer state =ConvertUtils.StringConvertInteger(stateStr);
        Integer parentId = ConvertUtils.StringConvertInteger(parentIdStr);
        Menu menu = new Menu(null,menuIcon,menuName,menuUrl,parentId,state);
        boolean flag = menuService.addMenu(menu);
        message = flag ? "a:{message:'添加成功'}":"a:{message:'添加失败'}";
        return message;
    }

    /**
     * 更新菜单信息
     * @param request
     * @param response
     * @return
     */
    public String updateMenu(HttpServletRequest request, HttpServletResponse response){
        String message ="";
        // 获取数据
        String menuName = request.getParameter("menuName");
        String menuIcon = request.getParameter("menuIcon");
        String parentIdStr = request.getParameter("parentId");
        String menuUrl = request.getParameter("menuUrl");
        String stateStr = request.getParameter("state");
        String idStr = request.getParameter("id");

        // 类型转换
        Integer id = ConvertUtils.StringConvertInteger(idStr);
        Integer state =ConvertUtils.StringConvertInteger(stateStr);
        Integer parentId = ConvertUtils.StringConvertInteger(parentIdStr);
        Menu menu = new Menu(id,menuIcon,menuName,menuUrl,parentId,state);
        boolean flag = menuService.updateMenu(menu);
        message = flag ? "a:{message:'修改成功'}":"a:{message:'修改失败'}";
        return message;
    }
}