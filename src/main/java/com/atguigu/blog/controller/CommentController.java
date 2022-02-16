package com.atguigu.blog.controller;

import com.atguigu.blog.exception.MyException;
import com.atguigu.blog.pojo.Comment;
import com.atguigu.blog.servier.CommentService;
import com.atguigu.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @create 2022-02-14 20:47
 */
@RestController
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    CommentService commentService;

    /**
     * 查询指定blogId的全部comment
     */
    @GetMapping("/{blogId}")
    public R selectByBlogId(@PathVariable("blogId") String blogId){

        List<Comment> comments = commentService.selectByBlogId(blogId);
        return new R(true,comments);
    }
    /**
     * 创建评论
     */
    @PostMapping
    public R create(@RequestBody Comment comment, HttpSession session) throws MyException {

        //第一次评论，将评论者信息保存到session域中
        if (session.getAttribute("comment") == null) {
            if (comment.getContent() == null || "".equals(comment.getContent())){
                throw new MyException("请输入评论内容！");
            }
            if (comment.getNickname() == null || "".equals(comment.getNickname())){
                throw new MyException("请输入姓名！");
            }
            if (comment.getEmail() == null || "".equals(comment.getEmail())){
                throw new MyException("请输入邮箱！");
            }

            session.setAttribute("comment",comment);
            boolean flag = commentService.create(comment);
            return new R(flag);
        }

        //之后评论，阻止评论者重新创建昵称和邮箱
        if (comment.getNickname() != null && !("".equals(comment.getNickname()))){
            throw new MyException("信息已录入，请勿重复输入！");
        }
        if (comment.getEmail() != null && !("".equals(comment.getEmail()))){
            throw new MyException("信息已录入，请勿重复输入！");
        }

        //取出session中的信息，保存到comment
        Comment commentTemp = (Comment) session.getAttribute("comment");
        comment.setNickname(commentTemp.getNickname());
        comment.setEmail(commentTemp.getEmail());

        boolean flag = commentService.create(comment);
        return new R(flag);
    }
//    /**
//     * 回复评论
//     */
//    @GetMapping("/{blogId}")
//    public R createReply(@PathVariable("blogId") String blogId){
//
//        List<Comment> comments = commentService.selectByBlogId(blogId);
//        return new R(true,comments);
//    }
}
