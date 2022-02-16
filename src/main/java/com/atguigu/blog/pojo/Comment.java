package com.atguigu.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
    private String id;

    private String nickname;

    private String email;

    private String heatPhoto = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202010%2F31%2F20201031163129_1840e.thumb.400_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1647586697&t=0fecbbe81665204c22e1641504dc0d7a";

    private String content;

    private Date createTime;

    private String blogId;

    private String commentId;

    private List<Comment> comments = new ArrayList<>();


    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", heatPhoto='" + heatPhoto + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", blogId='" + blogId + '\'' +
                ", commentId='" + commentId + '\'' +
                ", comments=" + comments +
                '}';
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeatPhoto() {
        return heatPhoto;
    }

    public void setHeatPhoto(String heatPhoto) {
        this.heatPhoto = heatPhoto == null ? null : heatPhoto.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId == null ? null : blogId.trim();
    }
}