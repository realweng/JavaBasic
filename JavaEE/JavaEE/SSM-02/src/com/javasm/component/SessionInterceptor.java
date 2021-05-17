package com.javasm.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/7-17:54
 * @Since:jdk1.8
 * @Description:登录拦截器
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    Logger logger = LogManager.getLogger(SessionInterceptor.class);

    /**
     * 判断是否登录，未登录直接拦截重定向到登录页面
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        Map<String, String[]> parameterMap = request.getParameterMap();
        StringBuilder stringBuilder = new StringBuilder();
        parameterMap.forEach((s,strings)->{
            stringBuilder.append("{ ");
            stringBuilder.append(s);
            stringBuilder.append(" : ");
            stringBuilder.append(Arrays.deepToString(strings));
            stringBuilder.append(" }");
        });
        String format =  String.format("path = %s , params = %s",requestURI,stringBuilder);
        logger.debug(format);
        logger.debug("path = "+requestURI + " params = "+stringBuilder);

        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("user");
        if(user == null){
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/login");
            return false;
        }else {
            return true;
        }
    }
}