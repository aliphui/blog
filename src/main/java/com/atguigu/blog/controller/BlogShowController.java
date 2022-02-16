package com.atguigu.blog.controller;

import com.atguigu.blog.exception.MyException;
import com.atguigu.blog.servier.BlogService;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @create 2022-02-13 15:27
 */
@RestController
@RequestMapping("/blog")
public class BlogShowController {

    @Autowired
    BlogService blogService;

    /**
     * 根据id查询指定blog(将content由markdown格式转为html)，以及tag，
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R blogById(@PathVariable("id") String id) throws MyException {

        Map<String, Object> blogMap = blogService.selectHtmlBlogById(id);


        return new R(true,blogMap);
    }
}
