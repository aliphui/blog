package com.atguigu.blog.test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @create 2022-02-08 14:44
 */
public class DataTest {

    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp);

    }
}
