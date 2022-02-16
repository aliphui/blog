package com.atguigu.blog.exception;

/**
 * 自定义异常类
 * @create 2022-02-13 15:39
 */
public class MyException extends Exception{
    static final long serialVersionUID = -3387524222342349948L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
