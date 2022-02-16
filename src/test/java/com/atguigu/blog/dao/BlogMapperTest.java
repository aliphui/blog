package com.atguigu.blog.dao;

import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.pojo.Type;
import com.atguigu.blog.utils.UUIDUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @create 2022-01-21 23:38
 */
@SpringBootTest
class BlogMapperTest {

    @Autowired
    BlogMapper mapper;
    @Autowired
    TypeMapper typeMapper;

    @Test
    void countByExample() {
    }

    @Test
    void deleteByExample() {
    }

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert1() {


    }
    @Test
    void insert2() {



    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByExample() {
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByExampleSelective() {
    }

    @Test
    void updateByExample() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }
}