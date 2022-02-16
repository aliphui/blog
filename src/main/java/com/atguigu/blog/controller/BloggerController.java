package com.atguigu.blog.controller;

import com.atguigu.blog.pojo.Blogger;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2022-02-11 16:34
 */
@RestController
@RequestMapping("/blogger")
public class BloggerController {

    @Autowired
    private Blogger blogger;

    @GetMapping
    public R blogger(){
        return new R(true,blogger);
    }
}
