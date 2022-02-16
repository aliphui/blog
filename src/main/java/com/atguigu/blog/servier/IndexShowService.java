package com.atguigu.blog.servier;

import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.pojo.Type;

import java.util.List;
import java.util.Map;

/**
 * @create 2022-02-10 14:51
 */
public interface IndexShowService {

    List<Map<String,Object>> selectTypeAddBlogCount();

    List<Map<String, Object>> selectTagAddBlogCount();

    List<Blog> selectRecommendBlog();

    List<Blog> selectBlogByTypeAndTag(String typeId, String tagId);

    List<Blog> selectNewBlogs(Integer count);
}
