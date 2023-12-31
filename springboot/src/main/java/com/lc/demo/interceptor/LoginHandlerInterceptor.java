package com.lc.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查，
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        Object user1 =request.getSession().getAttribute("User");
        System.out.println("添加跨域支持");
        //添加跨域CORS
        response.addHeader("Access-Control-Max-Age", "1800");//30 min
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,Content-Type,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        if(user == null){
            //未登陆，返回登陆页面
            request.setAttribute("msg","没有权限请先登陆");
            request.getRequestDispatcher("/abc/login").forward(request,response);
            return false;
        }else{
            if(user1.equals("admin")){
                return true;
            }else {
                if (request.getRequestURI().contains("/admin")) {
                    // 如果请求的URI包含/admin，表示用户试图访问管理员页面，拒绝访问
                    response.sendRedirect("/abc/login");
                    return false;
                }
            }
            //已登陆，放行请求

            return  true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
