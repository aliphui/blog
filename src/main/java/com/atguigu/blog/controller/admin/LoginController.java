package com.atguigu.blog.controller.admin;

import com.atguigu.blog.pojo.User;
import com.atguigu.blog.servier.UserService;
import com.atguigu.blog.utils.MD5Util;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @create 2022-01-22 19:41
 */
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;
    /**
     * 登录验证
     */
    @PostMapping("/login")
    public R login(@RequestBody User userTmp, HttpSession session){

        //将用户输入的密码使用md5加密，并保存
        userTmp.setPassward(MD5Util.getMD5(userTmp.getPassward()));

        User user = userService.login(userTmp);
        if (user != null){ //登录成功
            //将user保存到session域中
            session.setAttribute("user",user);
            return new R(true,"登陆成功");
        }else{//登录失败
            return new R(false, "用户名或密码错误");
        }
    }



}
