package com.javasm.web;

import com.alibaba.fastjson.JSONObject;
import com.javasm.entity.Area;
import com.javasm.service.AreaService;
import com.javasm.service.impl.AreaServiceImpl;
import com.javasm.util.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author：liulei
 * @Version：1.0
 * @Date：2021/4/2-17:02
 * @Since:jdk1.8
 * @Description:TODO
 */
@WebServlet("/getArea")
public class AreaServlet extends HttpServlet {

    private AreaService areaService = new AreaServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/plain;charset=utf-8");

        String type = request.getParameter("type");
        switch (type) {
            case "getProvince":
                showProvince(request, response);
                break;
            case "getCity":
                showCity(request, response);
                break;
            case "getDistrict":
                showDistrict(request, response);
                break;
            default:
                break;
        }
    }

    /**
     * 查询所有的省份
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void showProvince(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Area> areas = areaService.showAreaByLevel(1);

        // 将集合转为json的数据格式
        String json = JSONObject.toJSONString(areas);

        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
        out.close();

    }

    /**
     * 查询某省对应的市
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void showCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取省份ID
        String provinceStr = request.getParameter("id");

        Integer id = ConvertUtils.StringConvertInteger(provinceStr);

        List<Area> areas = areaService.showAreaByParentId(id);

        // 将集合转为json的数据格式
        String json = JSONObject.toJSONString(areas);

        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }

    /**
     * 通过市id查找区
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void showDistrict(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取市区ID
        String cityStr = request.getParameter("id");
        Integer id = ConvertUtils.StringConvertInteger(cityStr);
        List<Area> areas = areaService.showAreaByParentId(id);
        // 将集合转为json的数据格式
        String json = JSONObject.toJSONString(areas);
        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
        out.close();
    }
}
