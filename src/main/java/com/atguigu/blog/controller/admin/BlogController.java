package com.atguigu.blog.controller.admin;

import com.atguigu.blog.exception.MyException;
import com.atguigu.blog.pojo.Blog;
import com.atguigu.blog.pojo.User;
import com.atguigu.blog.servier.BlogService;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @create 2022-01-24 16:15
 */
@RestController
@RequestMapping("/admin/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    /**
     * 创建博客
     */
    @PostMapping
    public R create(Blog blog, String[] tagId, HttpSession session){

        //设置创建者id
        User user = (User) session.getAttribute("user");
        if (user != null){
            blog.setUserId(user.getId());
        }
        Boolean flag = blogService.create(blog,tagId);
        return new R(flag);
    }
    /**
     * 修改博客
     * @return
     */
    @PutMapping
    public R update(Blog blog, String[] tagId, HttpSession session){

        //设置修改者id
        User user = (User) session.getAttribute("user");
        if (user != null){
            blog.setUserId(user.getId());
        }
        Boolean flag = blogService.update(blog,tagId);

        return new R(flag);
    }
    /**
     * 查询博客，支持条件查询
     * @param blog
     * @return
     */
    @GetMapping
    public R select(Blog blog){
        List<Blog> blogList = blogService.select(blog);
        return new R(true,blogList);
    }

    /**
     * 删除博客
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") String id){
        boolean flag = blogService.delete(id);
        return new R(flag);
    }


    /**
     * 根据博客id查询指定博客
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R selectBlogById(@PathVariable("id") String id) throws MyException {
        Map<String,Object> map = blogService.selectById(id);
        return new R(true,map);
    }

}
