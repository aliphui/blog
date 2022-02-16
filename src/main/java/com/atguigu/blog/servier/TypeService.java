package com.atguigu.blog.servier;


import com.atguigu.blog.pojo.Type;

import java.util.List;

/**
 * @create 2022-01-25 17:22
 */
public interface TypeService {
    boolean create(Type type);

    boolean delete(String id);

    boolean update(Type type);

    List<Type> select();
}
