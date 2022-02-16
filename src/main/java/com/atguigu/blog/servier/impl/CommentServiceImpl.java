package com.atguigu.blog.servier.impl;

import com.atguigu.blog.dao.CommentMapper;
import com.atguigu.blog.pojo.Comment;
import com.atguigu.blog.servier.CommentService;
import com.atguigu.blog.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @create 2022-02-14 20:49
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    /**
     * 查询指定blogId的全部comment
     */
    @Override
    public List<Comment> selectByBlogId(String blogId) {

        //查找指定blogId的全部comment；
        List<Comment> commentList = commentMapper.selectByBlogId(blogId);

        //将全部comment区分为父级评论和子级评论

        //用于存放comment的最终列表
        List<Comment> comments = new ArrayList<>();

        for(Comment c1: commentList){
            if (c1.getCommentId() == null || c1.getCommentId().equals("")){
                for(Comment c2: commentList){
                    if (c1.getId().equals(c2.getCommentId())){
                        c1.getComments().add(c2);
                    }
                }
                comments.add(c1);
            }
        }

        return comments;
    }

    /**
     * 创建评论
     * @param comment
     * @return
     */
    @Override
    public boolean create(Comment comment) {

        //生成id,设置创建时间
        comment.setId(UUIDUtils.getId());
        comment.setCreateTime(new Date());

        int count = commentMapper.insert(comment);
        if (count < 1){
            return false;
        }
        return true;
    }
}
