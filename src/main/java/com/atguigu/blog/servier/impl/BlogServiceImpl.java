package com.atguigu.blog.servier.impl;

import com.atguigu.blog.dao.BlogAndTagMapper;
import com.atguigu.blog.dao.BlogMapper;
import com.atguigu.blog.dao.TagMapper;
import com.atguigu.blog.exception.MyException;
import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.pojo.BlogAndTag;
import com.atguigu.blog.pojo.Tag;
import com.atguigu.blog.servier.BlogService;
import com.atguigu.blog.utils.MarkdownUtils;
import com.atguigu.blog.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @create 2022-02-08 11:48
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogAndTagMapper blogAndTagMapper;

    @Autowired
    TagMapper tagMapper;

    @Override
    public Boolean create(Blog blog, String[] tagId) {

        //生成Id，生成创建时间和修改时间
        blog.setId(UUIDUtils.getId());
        blog.setCreateTime(new Timestamp(new Date().getTime()));
        blog.setUpdateTime(new Timestamp(new Date().getTime()));

        //设置浏览次数为0
        blog.setViews(0);

        System.out.println(blog);

        //创建blog
        int count1 = blogMapper.insert(blog);
        if (count1 < 1){
            return false;
        }

        //创建blog-tag关联关系
        if (tagId != null){
            for (int i = 0; i < tagId.length; i++) {
                BlogAndTag blogAndTag = new BlogAndTag();
                blogAndTag.setId(UUIDUtils.getId());
                blogAndTag.setBlogId(blog.getId());
                blogAndTag.setTagId(tagId[i]);

                int count2 = blogAndTagMapper.insert(blogAndTag);
                if (count2 < 1){
                    return false;
                }
            }
        }

        return true;
    }
    /**
     * 修改blog
     * @param blog
     * @param tagId
     * @return
     */
    @Override
    public Boolean update(Blog blog, String[] tagId) {

        //设置修改时间
        blog.setUpdateTime(new Timestamp(new Date().getTime()));

        //根据id修改blog
        int count1 = blogMapper.updateByIdSelective(blog);
        if (count1 < 1){
            return false;
        }

        //修改blog_tag关联关系
        //删除之前的关联关系
        blogAndTagMapper.deleteByBlogId(blog.getId());

        //重新添加关联关系
        if (tagId != null){
            for (int i = 0; i < tagId.length; i++) {
                BlogAndTag blogAndTag = new BlogAndTag();
                blogAndTag.setId(UUIDUtils.getId());
                blogAndTag.setBlogId(blog.getId());
                blogAndTag.setTagId(tagId[i]);

                int count3 = blogAndTagMapper.insert(blogAndTag);
                if (count3 < 1){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 条件查询指定博客，标题 支持模糊查询
     * @param blog
     * @return
     */
    @Override
    public List<Blog> select(Blog blog) {

        List<Blog> blogList = blogMapper.selectByBlog(blog);

        return blogList;
    }
    /**
     * 删除博客
     * @param id
     * @return
     */
    @Override
    public boolean delete(String id) {

        //删除blog_tag关联关系
        blogAndTagMapper.deleteByBlogId(id);

        //删除此blog对应的评论comment

        //删除此blog
        int count = blogMapper.deleteByPrimaryKey(id);
        if (count < 1){
            return false;
        }
        return true;
    }

    /**
     * 根据id查询指定blog，以及tag，
     * @param id
     * @return
     */
    @Override
    public Map<String,Object> selectById(String id){
        Blog blog = blogMapper.selectByPrimaryKey(id);
        List<Tag> tagList = tagMapper.selectByBlogId(id);

        Map map = new HashMap();
        map.put("blog",blog);
        map.put("tags",tagList);

        return map;
    }
    /**
     * 根据id查询指定blog(将content由markdown格式转为html)，以及tag，
     * @param id
     * @return
     */
    @Override
    public Map<String,Object> selectHtmlBlogById(String id) throws MyException {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        if (blog == null){
            throw new MyException("此博客不存在");
        }

        //浏览次数+1
        blog.setViews(blog.getViews() + 1);
        blogMapper.updateByPrimaryKey(blog);

        //将markdown格式的content转为html,
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));

        List<Tag> tagList = tagMapper.selectByBlogId(id);

        Map map = new HashMap();
        map.put("blog",blog);
        map.put("tags",tagList);

        return map;
    }

    @Override
    public List<Blog> selectLikeTitleAndContent(String searchData) {
        return blogMapper.selectLikeTitleAndContent(searchData);
    }


}
