package com.javasm.web;

import com.javasm.entity.ChannelType;
import com.javasm.service.ChannelTypeService;
import com.javasm.service.impl.ChannelTypeServiceImpl;
import com.javasm.util.ConvertUtils;
import com.javasm.util.RequestDataConvert;
import com.javasm.vo.ChannelTypeEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/14-21:30
 * @Since:jdk1.8
 * @Description:渠道种类的servlet
 */

@WebServlet("/channelType.do")
public class ChannelTypeServlet extends BaseServlet<ChannelTypeEntity> {
    private ChannelTypeService channelTypeService;
    private ChannelType channelType;

    /**
     * 构造器 初始化数据
     */
    public ChannelTypeServlet() {
        System.out.println("ChannelTypeServlet实例化");
        channelTypeService = new ChannelTypeServiceImpl();
        channelType = new ChannelType();
    }

    /**
     * 显示所有的渠道分类
     *
     * @param request
     * @param response
     * @return
     */
    public String showChannelType(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        List<ChannelTypeEntity> channelTypeEntityList = new ArrayList<>(10);
        channelTypeEntityList = channelTypeService.findAllChannelTypeEntity();
        request.setAttribute("channelTypeEntityList", channelTypeEntityList);
        message = "f:showChannelType.jsp";
        return message;
    }

    /**
     * 添加渠道种类
     *
     * @param request
     * @param response
     * @return
     */
    public String addChannelType(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            // 将请求的数据转化成实体类
            channelType = RequestDataConvert.convertToEntityByField(ChannelType.class, request);
            boolean flag = channelTypeService.addChannelType(channelType);
            if (flag) {
                request.setAttribute("message", "添加成功");
                message = "s:showChannelType.jsp";
            } else {
                request.setAttribute("message", "添加失败");
                message = "f:addChannelType.jsp";
            }
        } catch (IllegalAccessException e) {
            request.setAttribute("message", "添加失败");
            e.printStackTrace();
        } catch (InstantiationException e) {
            request.setAttribute("message", "添加失败");
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 删除渠道种类
     *
     * @param request
     * @param response
     * @return
     */
    public String deleteChannelType(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String channelTypeIdStr = request.getParameter("channelTypeId");
        Integer channelTypeId = ConvertUtils.StringConvertInteger(channelTypeIdStr);
        boolean flag = channelTypeService.deleteChannelType(channelTypeId);
        if (flag) {
            request.setAttribute("message", "删除成功");
            message = "s:showChannelType.jsp";
        } else {
            request.setAttribute("message", "删除失败");
            message = "f:showChannelType.jsp";
        }
        return message;
    }

    public String updateChannelType(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            // 将请求过来的数据转换成实体类
            channelType = RequestDataConvert.convertToEntityByField(ChannelType.class,request);
            boolean flag = channelTypeService.updateChannelType(channelType);
            if(flag){
                request.setAttribute("message","修改成功");
                message = "s:showChannelType.jsp";
            }else {
                request.setAttribute("message","修改失败");
                message = "f:showChannelType.jsp";
            }
        } catch (IllegalAccessException e) {
            request.setAttribute("message","修改失败");
            e.printStackTrace();
        } catch (InstantiationException e) {
            request.setAttribute("message","修改失败");
            e.printStackTrace();
        }
        return message;
    }
}