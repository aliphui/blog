package com.atguigu.blog.servier;

import com.atguigu.blog.pojo.Tag;

import java.util.List;

/**
 * @create 2022-01-24 16:21
 */
public interface TagService {
    boolean create(Tag tag);

    boolean delete(String id);

    boolean update(Tag tag);

    List<Tag> select();

}
