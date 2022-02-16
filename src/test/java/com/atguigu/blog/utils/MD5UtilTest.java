package com.atguigu.blog.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @create 2022-01-22 21:53
 */
class MD5UtilTest {

    @Test
    void getMD5() {

        String md5 = MD5Util.getMD5("qing151103430");
        System.out.println(md5);
    }
}