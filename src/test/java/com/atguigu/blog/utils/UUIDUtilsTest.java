package com.atguigu.blog.utils;

import org.junit.jupiter.api.Test;

import java.util.Date;



/**
 * @create 2022-01-21 23:22
 */
class UUIDUtilsTest {

    @Test
    void getId() {
        String id = UUIDUtils.getId();
        System.out.println(id);
    }
    @Test
    void test() {

        Date date = new Date();
        System.out.println(date);
    }
}