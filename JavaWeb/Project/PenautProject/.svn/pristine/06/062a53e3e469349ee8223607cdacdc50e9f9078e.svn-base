package com.javasm.web;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.javasm.entity.ChannelType;
import com.javasm.service.ChannelTypeService;
import com.javasm.service.impl.ChannelTypeServiceImpl;
import com.javasm.util.ConvertUtils;
import com.javasm.util.PageInfo;
import com.javasm.util.RequestDataConvert;
import com.javasm.vo.ChannelTypeEntity;

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
        // 获取页面信息
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");
        PageInfo<ChannelTypeEntity> pageInfo = channelTypeService.showTypeByPage(nowPage, pageNum);
        // 将对象转成json字符串 后面的2个参数是防止日期类型被格式化
        message ="a:"+JSONObject.toJSONString(pageInfo, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat);
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
        // 获取数据
        String typeName = request.getParameter("typeName");
        String parentIdStr = request.getParameter("parentId");
        String note = request.getParameter("note");
        String stateStr = request.getParameter("state");
        String createTimeStr = request.getParameter("createTime");

        // 数据类型转换
        Integer parentId = ConvertUtils.StringConvertInteger(parentIdStr);
        Integer state = ConvertUtils.StringConvertInteger(stateStr);
        Date createTime = new Date();
        try {
             createTime = ConvertUtils.StringConvertDate(createTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 将值放入对象
        channelType.setTypeName(typeName);
        channelType.setCreateTime(createTime);
        channelType.setNote(note);
        channelType.setState(state);
        channelType.setParentId(parentId);

        boolean flag = channelTypeService.addChannelType(channelType);
        message = flag ? "a:{message:'添加成功'}":"a:{message:'添加失败'}";
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
        String channelTypeIdStr = request.getParameter("id");
        Integer channelTypeId = ConvertUtils.StringConvertInteger(channelTypeIdStr);
        boolean flag = channelTypeService.deleteChannelType(channelTypeId);
        message = flag ? "a:{message:'删除成功'}":"a:{message:'删除失败'}";
        return message;
    }

    /**
     * 修改数据
     * @param request
     * @param response
     * @return
     */
    public String updateChannelType(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        // 获取数据
        String idStr = request.getParameter("id");
        String typeName = request.getParameter("typeName");
        String parentIdStr = request.getParameter("parentId");
        String note = request.getParameter("note");
        String stateStr = request.getParameter("state");
        String createTimeStr = request.getParameter("createTime");

        // 数据类型转换
        Integer parentId = ConvertUtils.StringConvertInteger(parentIdStr);
        Integer state = ConvertUtils.StringConvertInteger(stateStr);
        Integer id = ConvertUtils.StringConvertInteger(idStr);
        Date createTime = new Date();
        try {
            createTime = ConvertUtils.StringConvertDate(createTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 将值放入对象
        channelType.setId(id);
        channelType.setTypeName(typeName);
        channelType.setCreateTime(createTime);
        channelType.setNote(note);
        channelType.setState(state);
        channelType.setParentId(parentId);

        boolean flag = channelTypeService.updateChannelType(channelType);
        message = flag ? "a:{message:'修改成功'}":"a:{message:'修改失败'}";
        return message;
    }

    /**
     * 查询所有数据（不分页）
     * @param request
     * @param response
     * @return
     */
    public String findAllChannelType(HttpServletRequest request, HttpServletResponse response) {
        String message = "";
        // 获取页面信息
        List<ChannelTypeEntity> list = new ArrayList<>(10);
        list = channelTypeService.findAllChannelTypeEntity();
        message ="a:"+JSONObject.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat);
        return message;
    }
}