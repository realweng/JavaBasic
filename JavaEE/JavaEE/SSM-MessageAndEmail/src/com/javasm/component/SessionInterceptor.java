package com.javasm.component;

import com.javasm.constants.Constants;
import com.javasm.constants.RedisKeyConstants;
import com.javasm.service.RedisService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
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

    @Resource
    private RedisService redisService;
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

        Object user = getSession(request);
        if(user == null){
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/login");
            return false;
        }else {
            return true;
        }
    }

    /**
     * 从cookie中取值
     * @param request
     * @return
     */
    public Object getSession(HttpServletRequest request){
        Object result = null;
        //获取cookie数组
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if("id".equals(cookie.getName())){ //获取cookie为id的值
                    String redisKey = RedisKeyConstants.USER_SESSION_KEY + cookie.getValue();
                    result = redisService.get(redisKey); //查找redis
                    redisService.expire(redisKey, Constants.REDIS_SESSION_EXPIRE); //重置有效期
                }
            }
        }
        return result;
    }
}