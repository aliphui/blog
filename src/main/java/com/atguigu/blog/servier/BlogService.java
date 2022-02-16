package com.atguigu.blog.servier;

import com.atguigu.blog.exception.MyException;
import com.atguigu.blog.pojo.Blog;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * @create 2022-02-08 11:48
 */
public interface BlogService {
    Boolean create(Blog blog, String[] tagId);

    Boolean update(Blog blog, String[] tagId);

    List<Blog> select(Blog blog);

    boolean delete(String id);

    Map<String,Object> selectById(String id) throws MyException;

    Map<String, Object> selectHtmlBlogById(String id) throws MyException;

    List<Blog> selectLikeTitleAndContent(String searchData);
}
