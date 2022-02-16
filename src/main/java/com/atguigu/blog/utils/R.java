package com.atguigu.blog.utils;

/**
 * @create 2022-01-22 21:36
 */
public class R<T> {
    private boolean flag;
    private String message;
    private T data;

    public R(boolean flag) {
        this.flag = flag;
    }

    public R(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public R(boolean flag, T data) {
        this.flag = flag;
        this.data = data;
    }

    public R(boolean flag, String message, T data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "R{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

