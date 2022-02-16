package com.atguigu.blog.config;

import com.atguigu.blog.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @create 2022-02-09 22:28
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login.html")
                .excludePathPatterns("/admin/login");

    }
}
