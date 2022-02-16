package com.atguigu.blog.interceptor;

import com.atguigu.blog.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *拦截器，用于后台管理系统的拦截
 * @create 2022-02-09 20:33
 */
@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            response.sendRedirect("/admin/login.html");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
