package com.atguigu.blog.controller.admin;

import com.atguigu.blog.pojo.User;
import com.atguigu.blog.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @create 2022-01-22 19:34
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {

    @GetMapping
    public R selectUser(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null){
            return new R(true,user);
        }
        return new R(false);
    }
}
