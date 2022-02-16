package com.atguigu.blog.controller;

import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.pojo.Type;
import com.atguigu.blog.servier.IndexShowService;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @create 2022-02-10 14:35
 */
@RestController
@RequestMapping("/index")
public class IndexShowController {


    @Autowired
    IndexShowService indexShowService;

    /**
     * 按照type与tag 条件查询发布的博客信息
     */
    @GetMapping("/blogs")
    public R selectAllBlog(String typeId,String tagId){
        List<Blog> blogList = indexShowService.selectBlogByTypeAndTag(typeId,tagId);
        return new R(true,blogList);
    }
    /**
     * 查询最新博客
     */
    @GetMapping("/blogs/{count}")
    public R selectNewBlogs(@PathVariable("count") Integer count){
        List<Blog> blogList = indexShowService.selectNewBlogs(count);
        return new R(true,blogList);
    }

    /**
     * 查询所有分类，以及每个分类的博客数量
     */
    @GetMapping("/types")
    public R selectAllType(){
        List<Map<String,Object>> mapList = indexShowService.selectTypeAddBlogCount();
        return new R(true,mapList);
    }
    /**
     * 查询所有标签，以及每个标签的博客数量
     */
    @GetMapping("/tags")
    public R selectAllTag(){
        List<Map<String,Object>> mapList = indexShowService.selectTagAddBlogCount();
        return new R(true,mapList);
    }

    /**
     * 查询推荐博客,默认查询最新十条推荐
     */
    @GetMapping("/recommend")
    public R selectRecommendBlog(){
        List<Blog> blogs = indexShowService.selectRecommendBlog();
        return new R(true,blogs);
    }
}
