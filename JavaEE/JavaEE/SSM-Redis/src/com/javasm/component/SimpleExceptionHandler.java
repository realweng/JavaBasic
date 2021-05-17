package com.javasm.component;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/10-20:11
 * @Since:jdk1.8
 * @Description:TODO
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * @Author：albert
 * @Version：1.0
 * @Date：2021/5/10-16:25
 * @Since:jdk1.8
 * @Description:TODO
 *
 * 全局异常处理
 */
@Component
public class SimpleExceptionHandler implements HandlerExceptionResolver {
    Logger logger = LogManager.getLogger(SimpleExceptionHandler.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        StringBuilder params = new StringBuilder();
        params.append("{");
        parameterMap.forEach((s, strings) -> {
            params.append(s);
            params.append(" = ");
            params.append(Arrays.deepToString(strings));
        });
        params.append("}");
        String format = String.format("method : %s, Params : %s, Exception : %s", o, params, e.getLocalizedMessage());
        logger.error(format);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("base/error");
        modelAndView.addObject("msg","网络繁忙!");
        return modelAndView;
    }
}