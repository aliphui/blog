package com.atguigu.blog.servier.impl;

import com.atguigu.blog.dao.UserMapper;
import com.atguigu.blog.pojo.User;
import com.atguigu.blog.servier.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @create 2022-01-22 19:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper usermapper;


    @Override
    public User login(User user) {

        return usermapper.selectByUsernameAndPassward(user);
    }
}
