package com.atguigu.blog.exception;

import com.atguigu.blog.utils.R;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @create 2022-01-18 19:18
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R Exception(Exception  ex, Model model, HttpServletRequest request){
        StringBuffer url = request.getRequestURL();
        System.out.println("异常请求地址：" + url);
//        model.addAttribute("ex",ex);
        ex.printStackTrace();
        return new R(false,ex.getMessage());

    }
}
