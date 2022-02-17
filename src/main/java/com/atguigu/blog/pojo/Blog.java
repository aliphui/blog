package com.atguigu.blog.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Blog {
    private String id;

    private String title;

    private String content;

    private String defaultPicture;

    private String source;

    private Integer views;

    private String description;

    private Boolean recommend;

    private Boolean copyright;

    private Boolean appreciation;

    private Boolean comment;

    private Boolean published;

    private Timestamp createTime;

    private Timestamp updateTime;

    private String typeId;

    private String userId;

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", defaultPicture='" + defaultPicture + '\'' +
                ", source='" + source + '\'' +
                ", views=" + views +
                ", description='" + description + '\'' +
                ", recommend=" + recommend +
                ", copyright=" + copyright +
                ", appreciation=" + appreciation +
                ", comment=" + comment +
                ", published=" + published +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", typeId='" + typeId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDefaultPicture() {
        return defaultPicture;
    }

    public void setDefaultPicture(String defaultPicture) {
        this.defaultPicture = defaultPicture;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }

    public Boolean getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    public Boolean getComment() {
        return comment;
    }

    public void setComment(Boolean comment) {
        this.comment = comment;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}