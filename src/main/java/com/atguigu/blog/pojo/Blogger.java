package com.atguigu.blog.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.naming.Name;

/**
 * @create 2022-02-11 16:25
 */
@Component
@ConfigurationProperties(prefix = "blogger")
public class Blogger {
    private String name;

    private String qq;

    private String wechat;

    private String email;

    private String heatPhoto;

    @Override
    public String toString() {
        return "Blogger{" +
                "name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", email='" + email + '\'' +
                ", heatPhoto='" + heatPhoto + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeatPhoto() {
        return heatPhoto;
    }

    public void setHeatPhoto(String heatPhoto) {
        this.heatPhoto = heatPhoto;
    }
}
