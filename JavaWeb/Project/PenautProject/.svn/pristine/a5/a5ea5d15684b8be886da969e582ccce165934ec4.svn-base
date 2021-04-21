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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/21-15:09
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/channel.do")
public class ChannelServlet extends BaseServlet<ChannelEntity>{
    private ChannelService channelService;
    private ChannelEntity channelEntity;
    /**
     * 构造方法 初始化
     */
    public ChannelServlet() {
        System.out.println("ChannelServlet初始化");
        channelService = new ChannelServiceImpl();
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
        Channel channel = new Channel();
        String message = "";
        // 获取数据
        String typeIdStr = request.getParameter("typeId");
        String channelNumber = request.getParameter("channelNumber");
        String productName = request.getParameter("productName");
        String showName = request.getParameter("showName");
        String platformStr = request.getParameter("platform");
        String note = request.getParameter("note");
        String area = request.getParameter("area");
        String stateStr = request.getParameter("state");
        String createTimeStr = request.getParameter("createTime");

        // 数据类型转换
        Integer typeId = ConvertUtils.StringConvertInteger(typeIdStr);
        Integer platform = ConvertUtils.StringConvertInteger(platformStr);
        Integer state = ConvertUtils.StringConvertInteger(stateStr);
        Date createTime = new Date();
        try {
            createTime = ConvertUtils.StringConvertDate(createTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 将值放入对象
        channel.setTypeId(typeId);
        channel.setChannelNumber(channelNumber);
        channel.setCreateTime(createTime);
        channel.setState(state);
        channel.setArea(area);
        channel.setPlatform(platform);
        channel.setShowName(showName);
        channel.setProductName(productName);
        channel.setNote(note);

        boolean flag = channelService.addChannel(channel);
        message = flag ? "a:{message:'添加成功'}":"a:{message:'添加失败'}";
        return message;
    }

    /**
     * 删除渠道
     *
     * @return
     */
    public String deleteChannel(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        String channelIdStr = request.getParameter("id");
        Integer channelId = ConvertUtils.StringConvertInteger(channelIdStr);
        boolean flag = channelService.deleteChannel(channelId);
        message = flag ? "a:{message:'删除成功'}":"a:{message:'删除失败'}";
        return message;
    }

    /**
     * 更新渠道
     *
     * @return
     */
    public String updateChannel(HttpServletRequest request, HttpServletResponse response) {
        Channel channel = new Channel();
        String message = "";
        // 获取数据
        String typeIdStr = request.getParameter("typeId");
        String channelNumber = request.getParameter("channelNumber");
        String productName = request.getParameter("productName");
        String showName = request.getParameter("showName");
        String platformStr = request.getParameter("platform");
        String note = request.getParameter("note");
        String area = request.getParameter("area");
        String stateStr = request.getParameter("state");
        String createTimeStr = request.getParameter("createTime");
        String channelPath = request.getParameter("channelPath");
        String idStr = request.getParameter("id");

        // 数据类型转换
        Integer typeId = ConvertUtils.StringConvertInteger(typeIdStr);
        Integer platform = ConvertUtils.StringConvertInteger(platformStr);
        Integer state = ConvertUtils.StringConvertInteger(stateStr);
        Date createTime = new Date();
        try {
            createTime = ConvertUtils.StringConvertDate(createTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer id = ConvertUtils.StringConvertInteger(idStr);

        // 将值放入对象
        channel.setTypeId(typeId);
        channel.setChannelNumber(channelNumber);
        channel.setCreateTime(createTime);
        channel.setState(state);
        channel.setArea(area);
        channel.setPlatform(platform);
        channel.setShowName(showName);
        channel.setProductName(productName);
        channel.setNote(note);
        channel.setChannelPath(channelPath);
        channel.setId(id);
        boolean flag = channelService.updateChannel(channel);
        message = flag ? "a:{message:'地址添加成功'}":"a:{message:'地址添加失败'}"; ;
        return message;
    }
}