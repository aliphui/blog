package com.atguigu.blog.dao;

import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.pojo.BlogExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(String id);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);


    int updateByPrimaryKey(Blog record);

    int updateByIdSelective(Blog blog);

    List<Blog> selectByBlog(Blog blog);

    List<Blog> selectLikeTitleAndContent(String searchData);

    List<Blog> selectNewBlogs(Integer count);

    List<Blog> selectRecommendBlog();

    List<Blog> selectBlogByTypeAndTag(@Param("typeId") String typeId, @Param("tagId")String tagId);
}