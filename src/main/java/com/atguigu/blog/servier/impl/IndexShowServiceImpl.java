package com.atguigu.blog.servier.impl;

import com.atguigu.blog.dao.BlogMapper;
import com.atguigu.blog.dao.TagMapper;
import com.atguigu.blog.dao.TypeMapper;
import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.pojo.Type;
import com.atguigu.blog.servier.BlogService;
import com.atguigu.blog.servier.IndexShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @create 2022-02-10 14:52
 */
@Service
public class IndexShowServiceImpl implements IndexShowService {

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    BlogMapper blogMapper;
    /**
     * 查询所有分类，以及每个分类的博客数量
     */
    @Override
    public List<Map<String,Object>> selectTypeAddBlogCount() {
        return typeMapper.selectTypeAddBlogCount();
    }
    /**
     * 查询所有标签，以及每个标签的博客数量
     */
    @Override
    public List<Map<String, Object>> selectTagAddBlogCount() {
        return tagMapper.selectTagAddBlogCount();
    }

    /**
     * 查询指定数量的最新博客
     */
    @Override
    public List<Blog> selectNewBlogs(Integer count) {
        return blogMapper.selectNewBlogs(count);
    }

    /**
     * 查询推荐博客,默认查询最新十条推荐
     */
    @Override
    public List<Blog> selectRecommendBlog() {
        return blogMapper.selectRecommendBlog();
    }

    /**
     * 查询指定type和tag 的blog信息(发布状态)
     */
    @Override
    public List<Blog> selectBlogByTypeAndTag(String typeId, String tagId) {
        return blogMapper.selectBlogByTypeAndTag(typeId,tagId);
    }
}
