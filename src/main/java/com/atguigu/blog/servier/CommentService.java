package com.atguigu.blog.servier;

import com.atguigu.blog.pojo.Comment;

import java.util.List;

/**
 * @create 2022-02-14 20:49
 */
public interface CommentService {
    List<Comment> selectByBlogId(String blogId);

    boolean create(Comment comment);
}
