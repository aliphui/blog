package com.atguigu.blog.controller.admin;

import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.pojo.BlogAndTag;
import com.atguigu.blog.servier.BlogService;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制admin页面的跳转
 * @create 2022-01-24 15:28
 */
@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @Autowired
    BlogService blogService;

    /**
     * 跳转到登陆页
     */
    @GetMapping("/login.html")
    public String login(){
        return "admin/login";
    }
    /**
     * 跳转到登陆成功页
     */
    @GetMapping("/index.html")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/blogs.html")
    public String blogs(){
        return "admin/blogs";
    }
    @GetMapping("/blogs-input.html")
    public String blogsInput(){
        return "admin/blogs-input";
    }
    @GetMapping("/types.html")
    public String types(){
        return "admin/types";
    }
    @GetMapping("/types-input.html")
    public String typesInput(){
        return "admin/types-input";
    }
    @GetMapping("/tags.html")
    public String tags(){
        return "admin/tags";
    }
    @GetMapping("/tags-input.html")
    public String tagsInput(){
        return "admin/tags-input";
    }

    @GetMapping("/blogs-input.html/{id}")
    public String blogsInputAndId(@PathVariable("id") String id, Model model){
        model.addAttribute("id",id);
        return "admin/blogs-input";
    }

    @GetMapping("/blogs.html/{mgs}")
    public String blogsAndMgs(@PathVariable("mgs") String mgs,Model model){
        if ("publish".equals(mgs)){
            model.addAttribute("message","发布成功！");
        }
        if ("save".equals(mgs)){
            model.addAttribute("message","保存草稿成功！");
        }
        return "admin/blogs";
    }
}
