package com.yinqiantong.model;

import com.yinqiantong.common.Constants;

public class Res<T> {
    private String msg;
    private int code;
    private T data;

    public boolean isSuccess() {
        return code == Constants.CODE.SUCCESS;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public static class OrderRes extends Res<Order> {

    }
}
