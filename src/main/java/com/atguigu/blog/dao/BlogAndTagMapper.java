package com.atguigu.blog.dao;

import com.atguigu.blog.pojo.BlogAndTag;
import com.atguigu.blog.pojo.BlogAndTagExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogAndTagMapper {
    long countByExample(BlogAndTagExample example);

    int deleteByExample(BlogAndTagExample example);

    int deleteByPrimaryKey(String id);

    int insert(BlogAndTag record);

    int insertSelective(BlogAndTag record);

    List<BlogAndTag> selectByExample(BlogAndTagExample example);

    BlogAndTag selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BlogAndTag record, @Param("example") BlogAndTagExample example);

    int updateByExample(@Param("record") BlogAndTag record, @Param("example") BlogAndTagExample example);

    int updateByPrimaryKeySelective(BlogAndTag record);

    int updateByPrimaryKey(BlogAndTag record);

    void deleteByBlogId(String id);
}