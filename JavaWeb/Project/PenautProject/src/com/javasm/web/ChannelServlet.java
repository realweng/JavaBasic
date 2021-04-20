package com.javasm.web;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.javasm.entity.Channel;
import com.javasm.service.ChannelService;
import com.javasm.service.impl.ChannelServiceImpl;
import com.javasm.util.ConvertUtils;
import com.javasm.util.PageInfo;
import com.javasm.util.RequestDataConvert;
import com.javasm.vo.ChannelEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/15-21:30
 * @Since:jdk1.8
 * @Description:渠道servlet
 */
@WebServlet("/channel.do")
public class ChannelServlet extends BaseServlet<ChannelEntity> {
    private ChannelService channelService;
    private Channel channel;
    private ChannelEntity channelEntity;
    /**
     * 构造方法 初始化
     */
    public ChannelServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ChannelServlet初始化");
        channelService = new ChannelServiceImpl();
        channel = new Channel();
        channelEntity = new ChannelEntity();
    }

    /**
     * 显示所有渠道信息
     *
     * @return
     */
    public String showAllChannel(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        List<ChannelEntity> channelEntityList = new ArrayList<>(10);
        channelEntityList = channelService.findAllChannel();
        request.setAttribute("channelEntityList", channelEntityList);
        message = "f:showAllChannel.jsp";
        return message;
    }

    /**
     * 分页显示所有数据
     * @return
     */
    public String findAllChannelByPage(HttpServletRequest request, HttpServletResponse response){
        String message = "";
        // 获取分页信息 查询条件：渠道种类 渠道号模糊查询
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");
        String typeIdStr = request.getParameter("typeId");
        String channelNumber = request.getParameter("channelNumber");
        Integer typeId = ConvertUtils.StringConvertInteger(typeIdStr);
        channelEntity.setTypeId(typeId);
        channelEntity.setChannelNumber(channelNumber);
        PageInfo<ChannelEntity> pageInfo = channelService.findChannelByPage(channelEntity,nowPage,pageNum);
        message ="a:"+ JSONObject.toJSONString(pageInfo, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat);
        return message;
    }

    /**
     * 添加渠道
     *
     * @return
     */
    public String addChannel(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            // 将请求数据转换成渠道实体类
            channel = RequestDataConvert.convertToEntityByField(Channel.class,request);
            boolean flag = channelService.addChannel(channel);
            if(flag){
                request.setAttribute("message","添加成功");
                message = "s:showAllChannel.jsp";
            }else {
                request.setAttribute("message", "添加失败");
                message = "f:addChannel.jsp";
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
     * 删除渠道
     *
     * @return
     */
    public String deleteChannel(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String channelIdStr = request.getParameter("channelId");
        Integer channelId = ConvertUtils.StringConvertInteger(channelIdStr);
        boolean flag = channelService.deleteChannel(channelId);
        if (flag) {
            request.setAttribute("message", "删除成功");
            message = "s:showChannel.jsp";
        } else {
            request.setAttribute("message", "删除失败");
            message = "f:showChannel.jsp";
        }
        return message;
    }

    /**
     * 更新渠道
     *
     * @return
     */
    public String updateChannel(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        try {
            // 将请求过来的数据转换成实体类
            channel = RequestDataConvert.convertToEntityByField(Channel.class,request);
            boolean flag = channelService.updateChannel(channel);
            if(flag){
                request.setAttribute("message","修改成功");
                message = "s:showChannel.jsp";
            }else {
                request.setAttribute("message","修改失败");
                message = "f:showChannel.jsp";
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