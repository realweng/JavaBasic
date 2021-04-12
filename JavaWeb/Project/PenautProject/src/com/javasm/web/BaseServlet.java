package com.javasm.web;

import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.myenum.ResponseTypeEnum;
import com.javasm.util.RequestDataConvert;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/4/10-19:45
 * @Since:jdk1.8
 * @Description:TODO在BaseServlet中继承HttpServlet类，重写doGet、dopost方法，在服务方法中调用BaseServlet子类中的方法（业务处理的方法）
 * 其他的servlet类继承BaseServlet
 * 将request中的数据转为实体类对象
 */
public class BaseServlet<T> extends HttpServlet {
    private Class<T> entityClazz;

    /**
     * BaseServlet实例化
     */
    public BaseServlet() {
        entityClazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");

            // 1.获取servlet类中的Method
            Method method = getMethod(request);

            if (method != null) {
                // 2.获取当前方法中的参数（实体类、request、response）
                Object[] params = getMethodParam(method, request, response);

                // 3.调用Method
                Object invoke = method.invoke(this, params);

                // 4.响应数据到浏览器之上
                responseType(method, invoke, request, response);
            } else {// 资源不存在
                request.getRequestDispatcher("404.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // log4j：日志
            e.printStackTrace();
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }

    }

    /**
     * 获取需要执行的方法
     *
     * @param request
     * @return
     * @throws NoSuchMethodException
     */
    public Method getMethod(HttpServletRequest request) throws NoSuchMethodException {
        // 获取this的Class
        Class servletClazz = this.getClass();
        // 获取request中type的value
        String type = request.getParameter("type");
        // 获取this类中所有的方法
        Method[] declaredMethods = servletClazz.getDeclaredMethods();
        Method method = null;
        for (Method declaredMethod : declaredMethods) {
            // 如果declaredMethod方法名和type相等
            if (declaredMethod.getName().equals(type)) {
                method = declaredMethod;
                break;
            }
        }
        return method;
    }

    /**
     * 获取方法中需要传递的参数的值
     *
     * @param method
     * @param request
     * @param response
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public Object[] getMethodParam(Method method, HttpServletRequest request, HttpServletResponse response) throws InstantiationException, IllegalAccessException {
        // 方法参数值的数组对象
        Object[] parames = new Object[method.getParameterCount()];
        if (parames.length > 0) {
            // 获取方法参数的类型
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if (parameterTypes[i].getTypeName().equals("javax.servlet.http.HttpServletRequest")) {//请求对象
                    parames[i] = request;
                } else if (parameterTypes[i].getTypeName().equals("javax.servlet.http.HttpServletResponse")) {// 响应对象
                    parames[i] = response;
                } else if (parameterTypes[i].getTypeName().equals(entityClazz.getTypeName())) {// 实体类型
                    T entity = RequestDataConvert.convertToEntityByField(entityClazz, request);
                    parames[i] = entity;
                }
            }
        }
        return parames;
    }

    /**
     * 响应数据
     *
     * @param resultObject
     * @param request
     * @param response
     */
    public void responseType(Method method, Object resultObject, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取method的注解
        ResponseTypeAnnotation annotation = method.getAnnotation(ResponseTypeAnnotation.class);
        // 2.通过注解来响应数据
        if (annotation == null) {// 如果没有注解，通过返回值响应(响应方式有多种)
            String message = resultObject != null ? resultObject.toString() : null;
            // 通过resultMessage来对数据进行处理
            if (message != null) {
                // 解析message
                String[] split = message.split(":");
                if (split != null && split.length == 2) {
                    // 响应的类型
                    String responseType = split[0];
                    //  响应的数据
                    String responseMassage = split[1];
                    if (responseType.equals("f")) {//  响应方式为转发
                        request.getRequestDispatcher(responseMassage).forward(request, response);
                    } else if (responseType.equals("s")) {//  响应方式为重定向
                        response.sendRedirect(responseMassage);
                    } else if (responseType.equals("a")) {//  ajax
                        PrintWriter out = response.getWriter();
                        out.write(responseMassage);
                        out.flush();
                        out.close();
                    } else {
                        request.getRequestDispatcher("404.jsp").forward(request, response);
                    }
                }
            }
        } else {
            String message = resultObject != null ? resultObject.toString() : null;
            // 获取注解中的responseType的值
            ResponseTypeEnum responseTypeEnum = annotation.responseType();
            if (responseTypeEnum == ResponseTypeEnum.AJAX) {// ajax
                PrintWriter out = response.getWriter();
                out.write(message);
                out.flush();
                out.close();
            } else if (responseTypeEnum == ResponseTypeEnum.REDIRECT) {// 重定向
                response.sendRedirect(message);
            } else if (responseTypeEnum == ResponseTypeEnum.TRAN) {// 请求转发
                request.getRequestDispatcher(message).forward(request, response);
            } else {
                request.getRequestDispatcher("404.jsp").forward(request, response);
            }
        }
    }
}