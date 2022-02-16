package com.atguigu.blog.utils;

import java.util.UUID;

/**
 * @create 2022-01-21 23:13
 */
public class UUIDUtils {


    /**
     * 生成32位随机id
     * @return
     */
    public static String getId(){

        String id = UUID.randomUUID().toString().replace("-", "");

        return id;
    }
}
