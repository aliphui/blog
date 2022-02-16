package com.atguigu.blog.controller;

import com.atguigu.blog.exception.MyException;
import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.servier.BlogService;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @create 2022-02-14 17:16
 */
@RestController
@RequestMapping("/search")
public class SearchShowController {
    @Autowired
    BlogService blogService;

    /**
     * 搜索框模糊查询blog信息，按照title以及content
     */
    @GetMapping("/blogs/{searchData}")
    public R blogById(@PathVariable("searchData") String searchData) {

        List<Blog> blogs = blogService.selectLikeTitleAndContent(searchData);

        return new R(true,blogs);
    }
}
